package com.keshav.employeemanagement.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Department department;
	
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<EmployeeAddress> addressList;
	
	public void addAddress(EmployeeAddress address) {
		address.setEmployee(this);
		addressList.add(address);
	}
	
	public void deleteAddress(EmployeeAddress address) {
		addressList.remove(address);
		address.setEmployee(null);
	}

}
