package com.microservices.HotelService.services;

import java.util.List;

import com.microservices.HotelService.entities.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel get(String id);
}
