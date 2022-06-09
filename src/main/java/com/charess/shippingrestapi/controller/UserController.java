package com.charess.shippingrestapi.controller;

import com.charess.shippingrestapi.model.Person;
import com.charess.shippingrestapi.model.User;
import com.charess.shippingrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        List<?> objects = userService.getUsers();
        if (objects.toString().equals("[]"))
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(objects);
    }


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<?> getProfiles() {
        List<?> objects = userService.getProfiles();
        if (objects.size() == 0)
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(objects);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody User user) {
        System.out.println("USER : " + user);
        HttpHeaders textPlainHeaders = new HttpHeaders();
        textPlainHeaders.setContentType(MediaType.TEXT_PLAIN);
        try {
            if (user == null) {
                return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
            }
            if (user.getId() == null) {
                if (userService.findByUsername(user.getUsername()) != null) {
                    return new ResponseEntity<>("username", textPlainHeaders, HttpStatus.CONFLICT);
                }
                if (userService.findByEmail(user.getPerson().getEmail()) != null) {
                    return new ResponseEntity<>("email", textPlainHeaders, HttpStatus.CONFLICT);
                }
            }
            return new ResponseEntity<>(userService.register(user, user.getId() == null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody List<User> users) {
        try {
            userService.update(users);
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }


    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public Person getPerson(@RequestParam("key") String key) {
        return userService.getPerson(key);
    }

}
