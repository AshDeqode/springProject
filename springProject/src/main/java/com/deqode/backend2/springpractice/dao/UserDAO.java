package com.deqode.backend2.springpractice.dao;

import com.deqode.backend2.springpractice.model.User;

public interface UserDAO {
	public User createUser(User user);
	
	public User findByUserName(String userName);
}
