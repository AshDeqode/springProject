package com.deqode.backend2.springpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deqode.backend2.springpractice.dao.UserDAO;
import com.deqode.backend2.springpractice.model.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User createUser(User user) {
		User theUser = userDAO.createUser(user);
		return theUser;
	}

}
