package com.microservices.UserService.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.UserService.entities.User;
import com.microservices.UserService.services.UserService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		return userService.getAllUser();
	}
	
	int count = 1;
	
	@GetMapping("/{id}")
	//@CircuitBreaker(name="ratingHotelBreaker", fallbackMethod = "fallback")
	//@Retry(name="ratingHotelRetry", fallbackMethod = "fallback")
	@RateLimiter(name="ratingHotelRateLimiter", fallbackMethod = "fallback")
	public ResponseEntity<User> getUserById(@PathVariable("id") String userId){
		logger.info("Retry count: " + count++);
		User user;
		try {
			user=userService.getUser(userId);
			return ResponseEntity.ok(user);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//creating fall back method for circuit breaker
	public ResponseEntity<User> fallback(String userid, Throwable t){
		
		logger.info("Fallback is executed because service is down: ",t.getMessage());
		
		User user = User.builder()
			.email("dummy@gmail.com")
			.name("Dummy")
			.about("This user is created dummy because rating and hotel service is down")
			.userId("1234")
			.build();
		
		return ResponseEntity.ok(user);
		
		
	}
}
