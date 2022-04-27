package com.deqode.backend2.springpractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deqode.backend2.springpractice.dao.FriendsDAO;
import com.deqode.backend2.springpractice.model.Friends;

@Service
public class FriendsServiceImpl implements FriendsService {
	
	//Dependency Injection of DAO class
	@Autowired
	private FriendsDAO friendsDao;
	
	//method to get list of all the friends
	@Override
	public List<Friends> getAllFriends() {
		List<Friends> listOfFriends = friendsDao.getAllFriends();
		
		return listOfFriends;
	}
	
	//method to save or update your friend
	@Override
	public Friends saveorUpdate(Friends friend) {
		Friends theFriend = friendsDao.saveorUpdate(friend);
		
		return theFriend;
	}
	
	//method to find friend by ID 
	@Override
	public Friends findFriendById(Integer id) {
		Friends theFriend = friendsDao.findFriendById(id);
		
		return theFriend;
	}
	
	//method to delete friend by ID
	@Override
	public void deleteFriendship(Integer id) {	
		friendsDao.deleteFriendship(id);
	}
	
	//method to find friends with name
	@Override
	public List<Friends> findFriendByName(String name) {
		List<Friends> theFriends = friendsDao.findFriendByName(name);
		
		return theFriends;
	}
	
	//method to find friends with city name
	@Override
	public List<Friends> findFriendByCity(String cityName) {
		List<Friends> theFriends = friendsDao.findFriendByCity(cityName);
		
		return theFriends;
	}
	
	//method to find friends with country name
	@Override
	public List<Friends> findFriendByCountry(String countryName) {
		List<Friends> theFriends = friendsDao.findFriendByCountry(countryName);
		
		return theFriends;
	}
}
