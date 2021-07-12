package com.example.restapi;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;

@RestController
@Log
public class UserController {
	
	private final AtomicInteger count = new AtomicInteger(1000); 

	@GetMapping(value= "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser() {
		
		User user = new User(1L, "Anthony", "Qin", 17);
		return user;
	}
	
	@PostMapping(value = "/api/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		user.setId(count.incrementAndGet());
		log.info(user.toString());
		
		ResponseEntity<User> response = ResponseEntity.ok(user);
		
		return response;
	}
}
