package com.keshav.employeemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keshav.employeemanagement.entity.EmployeeAddress;
import com.keshav.employeemanagement.service.EmployeeAddressService;

@RestController
@RequestMapping("/address")
public class EmployeeAddressController {
	
	@Autowired
	private EmployeeAddressService employeeAddressService;

	@GetMapping("/{addressId}")
	public ResponseEntity<?> getEmployeeAddressById(@PathVariable("addressId") Long addressId){
		EmployeeAddress address = employeeAddressService.getEmployeeAddressByAddressId(addressId);
		return new ResponseEntity<EmployeeAddress>(address, HttpStatus.OK);
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<?> getEmployeeAddressListByEmployeeId(@PathVariable("employeeId") Long empId){
		List<EmployeeAddress> addressList = employeeAddressService.getEmployeeAddressListByEmployeeId(empId);
		return new ResponseEntity<List<EmployeeAddress>>(addressList, HttpStatus.OK);
	}
	
	@PostMapping("/{empId}")
	public ResponseEntity<?> addEmployeeAddress(@PathVariable("empId") Long empId,@RequestBody EmployeeAddress address){
		employeeAddressService.addEmployeeAddress(empId, address);
		return new ResponseEntity<String>("Employee address added successfuly",HttpStatus.OK);
	}
}
