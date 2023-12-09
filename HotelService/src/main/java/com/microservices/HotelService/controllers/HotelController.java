package com.microservices.HotelService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.HotelService.entities.Hotel;
import com.microservices.HotelService.services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@PostMapping("/")
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return hotelService.createHotel(hotel);
	}
	
	@GetMapping("/")
	public List<Hotel> getAll(){
		return hotelService.getAll();
	}
	
	@GetMapping("/{id}")
	public Hotel getById(@PathVariable("id") String id) {
		return hotelService.get(id);
	}
}
