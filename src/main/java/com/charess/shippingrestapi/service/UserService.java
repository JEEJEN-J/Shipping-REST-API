package com.charess.shippingrestapi.service;


import com.charess.shippingrestapi.model.Audit;
import com.charess.shippingrestapi.model.Person;
import com.charess.shippingrestapi.model.Profile;
import com.charess.shippingrestapi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean sendMail(String toEmail, String subject, String message);

    User findByUsername(String username);

    Audit inject(Audit audit);

    User findById(Integer id);

    List<User> getUsers();

    List<Profile> getProfiles();

    Person findByEmail(String email);

    Object register(User user);

    Object update(User user);

    Person getPerson(String key);
}
