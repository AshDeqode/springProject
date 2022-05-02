package com.deqode.backend2.springpractice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "userInfo")
public class User {
	@Id
	private Integer id;
	
	private String username;
	
	private String password;
}
