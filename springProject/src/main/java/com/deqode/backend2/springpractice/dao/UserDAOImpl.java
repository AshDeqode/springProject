package com.deqode.backend2.springpractice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.deqode.backend2.springpractice.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public User createUser(User user) {
		User theUser = mongoTemplate.save(user);
    	
    	return theUser;
	}

	@Override
	public User findByUserName(String userName) {
		Query query = new Query();
		
		query.addCriteria(Criteria.where("username").is(userName));
		
		User theUser = mongoTemplate.findOne(query, User.class);
		
		return theUser;
	}

}
