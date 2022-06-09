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

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ProfileRepository profileRepository,
                           PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.personRepository = personRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public Audit inject(Audit audit) {
        if (audit == null)
            return audit;
        if (audit.getId() == null) {
            audit.setCreated(LocalDateTime.now());
        } else {
            audit.setEdited(LocalDateTime.now());
        }
        return audit;
    }

    public List<User> getUsers() {
        return userRepository.find();
    }

    public List<Profile> getProfiles() {
        return profileRepository.findAll().stream().filter(profile -> profile.getId() > 1).collect(Collectors.toList());
    }

    public Person findByEmail(String email) {
        return email == null ? null : personRepository.findByEmail(email);
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
        user.setPerson(person);
        return userRepository.save(user);
    }

    public void update(List<User> users) {
        for (User u : users) {
            boolean encodePassword = u.getStatus().equals(Status.USER_PENDING);
            u.setPassword(encodePassword ? u.getUsername() : u.getPassword());
            register(u, encodePassword);
        }
    }

    public Person getPerson(String key) {
        Person person = null;
        if (key.trim().length() > 0) {
            if (key.split("@").length > 1)
                person = personRepository.findByEmail(key);
        }
        return person;
    }


}
