package com.keshav.employeemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class EmployeeAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String road;
	
	private String apartmentName;
	
	private String houseNumber;
	
	private String pincode;
	
	private String type;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="employee_id", referencedColumnName = "id")
	@JsonBackReference
	private Employee employee;
	
}
