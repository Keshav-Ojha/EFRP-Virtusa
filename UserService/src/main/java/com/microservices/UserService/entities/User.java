package com.microservices.UserService.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
public class User {
	
	@Id
	private String userId;
	private String name;
	private String email;
	private String about;
	
	
	
	public User(String userId, String name, String email, String about, List<Rating> ratings) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.about = about;
		this.ratings = ratings;
	}



	@Transient
	private List<Rating> ratings= new ArrayList<>();
}
