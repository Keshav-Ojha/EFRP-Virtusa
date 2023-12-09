package com.microservices.HotelService.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.microservices.HotelService.entities.Hotel;
import com.microservices.HotelService.repositories.HotelRepository;
import com.microservices.HotelService.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String randomId = UUID.randomUUID().toString();
		hotel.setId(randomId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hotelRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	

}
