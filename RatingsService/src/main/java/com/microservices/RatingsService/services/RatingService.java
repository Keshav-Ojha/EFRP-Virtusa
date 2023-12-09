package com.microservices.RatingsService.services;

import java.util.List;

import com.microservices.RatingsService.entities.Rating;

public interface RatingService {

	Rating addRating(Rating rating);
	
	List<Rating> getAllRatings();
	
	List<Rating> getAllByUserId(String userId);
	
	List<Rating> getAllByHotelId(String hotelId);
	
}
