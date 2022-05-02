package com.deqode.backend2.springpractice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deqode.backend2.springpractice.dao.UserDAO;

@Service
public class CustomUserDetailService implements UserDetailsService{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.deqode.backend2.springpractice.model.User theUser = userDAO.findByUserName(username);
		
		if(theUser == null) {
			throw new UsernameNotFoundException("User not found");
		}
		else{
			return new User(theUser.getUsername(), theUser.getPassword(), new ArrayList<>());
		}
	}

}
