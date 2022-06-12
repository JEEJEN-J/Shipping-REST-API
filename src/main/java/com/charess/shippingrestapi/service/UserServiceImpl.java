package com.charess.shippingrestapi.service;


import com.charess.shippingrestapi.model.Audit;
import com.charess.shippingrestapi.model.Person;
import com.charess.shippingrestapi.model.Profile;
import com.charess.shippingrestapi.model.Status;
import com.charess.shippingrestapi.model.User;
import com.charess.shippingrestapi.repository.PersonRepository;
import com.charess.shippingrestapi.repository.ProfileRepository;
import com.charess.shippingrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ProfileRepository profileRepository;
    private PersonRepository personRepository;
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String fromEmail;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ProfileRepository profileRepository,
                           PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.personRepository = personRepository;
    }


    public boolean sendMail(String toEmail, String subject, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(this.fromEmail);
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

//        this.javaMailSender.send(mailMessage);
        return true;
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

    public User findById(Integer id) {
        return userRepository.getOne(id);
    }

    public Object register(User user) {
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
        System.out.println("Save...");
        Object userSave = userRepository.save(user);
        System.out.println("Usrer-save : " + userSave);
        return userSave;
    }

    public Object update(User user) {
        return register(user);
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
