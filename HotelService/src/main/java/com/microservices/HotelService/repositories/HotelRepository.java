package com.microservices.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
