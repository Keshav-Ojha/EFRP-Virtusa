package com.microservices.HotelService.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Hotel {

	@Id
	private String id;
	private String name;
	private String location;
	private String about;
}
