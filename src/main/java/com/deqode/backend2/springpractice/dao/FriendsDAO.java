package com.deqode.backend2.springpractice.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.deqode.backend2.springpractice.model.Friends;

public interface FriendsDAO{
	
	//method to create or update a friend
	public Friends saveorUpdate(Friends friend);
	
	//method to get list of all friends
	public List<Friends> getAllFriends();
	
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
