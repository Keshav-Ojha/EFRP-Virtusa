package com.microservices.RatingsService.contorllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.RatingsService.entities.Rating;
import com.microservices.RatingsService.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/")
	public Rating createRating(@RequestBody Rating rating) {
		return ratingService.addRating(rating);
	}
	
	@GetMapping("/")
	public List<Rating> getAllRatings(){
		return ratingService.getAllRatings();
	}
	
	@GetMapping("/user/{userId}")
	public List<Rating> getAllRatingsByUserId(@PathVariable String userId){
		return ratingService.getAllByUserId(userId);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public List<Rating> getAllRatingsByHotelId(@PathVariable String hotelId){
		return ratingService.getAllByHotelId(hotelId);
	} 
	
}
