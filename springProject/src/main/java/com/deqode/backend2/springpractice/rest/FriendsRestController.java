package com.deqode.backend2.springpractice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deqode.backend2.springpractice.model.Friends;
import com.deqode.backend2.springpractice.service.FriendsServiceImpl;

@RestController
@RequestMapping("/friends")
public class FriendsRestController {
	//Dependency Injection of Service class
	@Autowired
	private FriendsServiceImpl friendsService;
	
	//controller method to get list of all the friends
	@GetMapping("/getall")
	public List<Friends> getAllTheFriends(){
		return friendsService.getAllFriends();
	}
	
	//controller method to find your friend by ID
	@GetMapping("/findById/{id}")
	public Friends getFriendById(@PathVariable Integer id) {
		return friendsService.findFriendById(id);
	}
	
	//controller method to create a new friend
	@PostMapping("/create")
	public Friends makeAFriend(@RequestBody Friends theFriends){
		return friendsService.saveorUpdate(theFriends);
	}
	
	//controller method to update your friend
	@PutMapping("/update")
	public Friends updateAFriend(@RequestBody Friends theFriends){
		return friendsService.saveorUpdate(theFriends);
	}
	
	//controller method to delete a friend by ID
	@DeleteMapping("/delete/{id}")
	public String deleteFriendship(@PathVariable Integer id) {
		Friends theFriend = friendsService.findFriendById(id);
		
		//checking if friend exist in DB or not
		if(theFriend == null) {
			throw new RuntimeException("Friend with id : " + id + " does not exist");
		}
		else {
			friendsService.deleteFriendship(id);
			
			String theMessage = "Your Friendship with " + theFriend.getFirstName() + " "
					+ theFriend.getLastName() + " has ended, hope you guys become friends again :)";
			
			return theMessage;
		} 
	}
	
	//controller method to find your friend by name
	@GetMapping("/findByName/{name}")
	public List<Friends> getFriendByName(@PathVariable String name) {
		return friendsService.findFriendByName(name);
	}
		
	//controller method to find your friend by city Name
	@GetMapping("/findByCity/{cityName}")
	public List<Friends> getFriendByCity(@PathVariable String cityName) {
		return friendsService.findFriendByCity(cityName);
	}
		
	//controller method to find your friend by country name
	@GetMapping("/findByCountry/{countryName}")
	public List<Friends> getFriendByCountry(@PathVariable String countryName) {
		return friendsService.findFriendByCountry(countryName);
	}
}
