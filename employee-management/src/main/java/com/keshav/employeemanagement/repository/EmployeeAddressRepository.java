package com.keshav.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keshav.employeemanagement.entity.EmployeeAddress;

public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, Long>{
	
}
