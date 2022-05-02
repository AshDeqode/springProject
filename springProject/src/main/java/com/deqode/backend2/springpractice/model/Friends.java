package com.deqode.backend2.springpractice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

//Using Lombok to remove redundant boiler plate code
@Data
@Document(collection = "friendInfo")
public class Friends {
	
	@Id
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String city;
	
	private String country;
}
