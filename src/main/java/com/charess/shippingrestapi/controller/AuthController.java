package com.charess.shippingrestapi.controller;


import com.charess.shippingrestapi.config.JwtTokenUtil;
import com.charess.shippingrestapi.model.User;
import com.charess.shippingrestapi.service.AuthUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil token;
    private AuthUserService authUserService;
    private final Logger log = LoggerFactory.getLogger(AuthController.class);


    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil token, AuthUserService authUserService) {
        this.authenticationManager = authenticationManager;
        this.token = token;
        this.authUserService = authUserService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> generateAuthenticationToken(@RequestBody User user) throws Exception {
        authenticate(user.getUsername(), user.getPassword());
        UserDetails details = authUserService.loadUserByUsername(user.getUsername());
        User usr = authUserService.findByUsername(user.getUsername());
        if(usr != null)
            usr.setToken(token.generateToken(details));
        return ResponseEntity.ok(usr);
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
