package com.microservices.RatingsService.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.RatingsService.entities.Rating;
import com.microservices.RatingsService.repositories.RatingRepository;
import com.microservices.RatingsService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepository ratingRepository;
	
	@Override
	public Rating addRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
