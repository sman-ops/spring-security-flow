package com.spring.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Subscriber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	
	private String email; // username
	
	private String password;  // password
	
	private String role ; // authorities
	
	
	
	

}
