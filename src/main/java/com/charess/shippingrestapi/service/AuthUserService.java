package com.charess.shippingrestapi.service;

import java.util.ArrayList;

import com.charess.shippingrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("techgeeknext".equals(username)) {
			return new User("techgeeknext", "$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		com.charess.shippingrestapi.model.User usr = userRepository.findByUsername(username);
//
//		User user = (usr !=null && (usr.getStatus().equals(Status.USER_ACTIVE.toString()) || usr.getStatus().equals(Status.USER_PENDING.toString())))?
//				new User(usr.getUsername(), usr.getPassword(), usr.getAuthorities()):null;
//		return user;
//	}
//
	public com.charess.shippingrestapi.model.User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
