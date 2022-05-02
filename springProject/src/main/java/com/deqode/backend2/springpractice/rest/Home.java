package com.deqode.backend2.springpractice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.deqode.backend2.springpractice.model.User;
import com.deqode.backend2.springpractice.service.UserService;

@RestController
@RequestMapping("/")
public class Home {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/welcome")
	public String welcome() {
		String text = "This page hides some preciuos gemstones"
				+ ", authenticate yourself to atleast have a look on them!";
		
		return text;
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		User theUser = userService.createUser(user);
		
		return theUser;
	}
}
