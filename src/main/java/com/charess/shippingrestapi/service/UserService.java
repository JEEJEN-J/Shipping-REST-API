package com.charess.shippingrestapi.service;


import com.charess.shippingrestapi.model.Audit;
import com.charess.shippingrestapi.model.Person;
import com.charess.shippingrestapi.model.Profile;
import com.charess.shippingrestapi.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    User getCurrentUser();
    Audit inject(Audit audit);
    List<User> getUsers();
    List<Profile> getProfiles();
    Person findByEmail(String email);
    User register(User user, boolean encodePassword);
    void update(List<User> users);
    Person getPerson(String key);
}
