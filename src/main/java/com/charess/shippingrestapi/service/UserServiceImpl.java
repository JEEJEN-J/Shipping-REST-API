package com.charess.shippingrestapi.service;


import com.charess.shippingrestapi.model.Audit;
import com.charess.shippingrestapi.model.Person;
import com.charess.shippingrestapi.model.Profile;
import com.charess.shippingrestapi.model.Status;
import com.charess.shippingrestapi.model.User;
import com.charess.shippingrestapi.repository.PersonRepository;
import com.charess.shippingrestapi.repository.ProfileRepository;
import com.charess.shippingrestapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ProfileRepository profileRepository;
    private PersonRepository personRepository;
    private PasswordEncoder passwordEncoder;

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ProfileRepository profileRepository,
                           PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.passwordEncoder = passwordEncoder;
        this.personRepository = personRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        User user = null;
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User){
                String username = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername();
                user = userRepository.findByUsername(username);
            }
        }
        return user;
    }

    public Audit inject(Audit audit){
        if(audit==null)
            return audit;
        if(audit.getId() == null){
            audit.setCreator(getCurrentUser());
            audit.setCreated(LocalDateTime.now());
        } else {
            audit.setEditor(getCurrentUser());
            audit.setEdited(LocalDateTime.now());
        }
        return audit;
    }

    public List<User> getUsers(){
        return userRepository.find();
    }

    public List<Profile> getProfiles(){
        return profileRepository.findAll().stream().filter(profile -> profile.getId() > 1).collect(Collectors.toList());
    }

    public Person findByEmail(String email){
        return email==null?null:personRepository.findByEmail(email);
    }

    public User register(User user, boolean encodePassword) {
        if (user.getPassword() == null && user.getId() != null) {
            userRepository.findById(user.getId()).ifPresent(u -> user.setPassword(u.getPassword()));
        }
        Person person = user.getPerson();
        if (person != null) {
            if (user.getPassword() == null) {
                user.setPassword(user.getUsername());
                user.setStatus(Status.USER_PENDING.toString());
            }
            person = personRepository.save(person);
        }
        if (encodePassword) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        if (getCurrentUser() != null && user.getId() == null)
            user.setStatus(Status.USER_PENDING.toString());
        if (getCurrentUser() != null && user.getActivatedBy() == null && user.getStatus().equals(Status.USER_ACTIVE.toString())) {
            user.setActivatedBy(getCurrentUser());
            user.setActivatedDate(LocalDateTime.now());
        }
        if (user.getId() != null && getCurrentUser() != null && user.getStatus().equals(Status.USER_PENDING.toString())) {
            user.setPassword(passwordEncoder.encode(user.getUsername()));
        }
        user.setPerson(person);
        return userRepository.save(user);
    }

    public void update(List<User> users){
        for(User u: users){
            boolean encodePassword = u.getStatus().equals(Status.USER_PENDING);
            u.setPassword(encodePassword?u.getUsername():u.getPassword());
            register(u, encodePassword);
        }
    }

    public Person getPerson(String key){
        Person person = null;
        if(key.trim().length() > 0){
            if(key.split("@").length > 1)
                person = personRepository.findByEmail(key);
        }
        return person;
    }


}
