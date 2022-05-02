package com.deqode.backend2.springpractice.service;

import java.util.List;

import com.deqode.backend2.springpractice.model.Friends;

public interface FriendsService {
	
	//method to get list of all the friends
	public List<Friends> getAllFriends();
	
	//method to save or update your friend
	public Friends saveorUpdate(Friends friend);
	
	//method to find friend by ID 
	public Friends findFriendById(Integer id);
	
	//method to delete friend by ID
	public void deleteFriendship(Integer id);
	
	//method to find friends by name
	public List<Friends> findFriendByName(String name);
	
	//method to find friends by city
	public List<Friends> findFriendByCity(String name);
		
	//method to find friends by country
	public List<Friends> findFriendByCountry(String name);
}
