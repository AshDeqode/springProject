package com.deqode.backend2.springpractice.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.deqode.backend2.springpractice.model.Friends;

@Repository
public class FriendsDAOMongoImpl implements FriendsDAO {
	//DI for Mongo Template to access all methods of Mongo Repository
	@Autowired
	MongoTemplate mongoTemplate;
	
	//method to get list of all friends
    public Friends saveorUpdate(Friends friend) {
    	Friends theFriend = mongoTemplate.save(friend);
    	
    	return theFriend;
    }
    
    //method to create or update a friend
    public List<Friends> getAllFriends(){
    	List<Friends> listOFriends = mongoTemplate.findAll(Friends.class);
    	
    	return listOFriends;
    }
    
    //method to delete friend by ID
	@Override
	public void deleteFriendship(Integer id) {
		Friends thefriend = mongoTemplate.findById(id, Friends.class);
		
		mongoTemplate.remove(thefriend);
	}
	
	//method to find friend by ID 
	@Override
	public Friends findFriendById(Integer id) {
		Friends theFriend = mongoTemplate.findById(id, Friends.class);
		
		return theFriend;
	}
	
	//method to find friends with name
	@Override
	public List<Friends> findFriendByName(String name) {
		Query query = new Query();
		
		query.addCriteria(Criteria.where("firstName").is(name));
		
		List<Friends> theFriends = mongoTemplate.find(query, Friends.class);
		
		return theFriends;
	}
	
	//method to find friends with city name
	@Override
	public List<Friends> findFriendByCity(String cityName) {
		Query query = new Query();
		
		query.addCriteria(Criteria.where("city").is(cityName));
		
		List<Friends> theFriends = mongoTemplate.find(query, Friends.class);
		
		return theFriends;
	}
	
	//method to find friends with country name
	@Override
	public List<Friends> findFriendByCountry(String countryName) {
		Query query = new Query();
		
		query.addCriteria(Criteria.where("country").is(countryName));
		
		List<Friends> theFriends = mongoTemplate.find(query, Friends.class);
		
		return theFriends;
	}
}
