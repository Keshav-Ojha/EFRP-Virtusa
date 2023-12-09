package com.keshav.employeemanagement.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keshav.employeemanagement.entity.Employee;
import com.keshav.employeemanagement.entity.EmployeeAddress;
import com.keshav.employeemanagement.repository.EmployeeAddressRepository;
import com.keshav.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeAddressRepository employeeAddressRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<EmployeeAddress> addEmployeeAddress(Long empId, EmployeeAddress address) {
		Employee employee = employeeRepository.findById(empId).orElseThrow(EntityNotFoundException::new);
		employee.addAddress(address);
		Employee modifiedEmployee = employeeRepository.save(employee);
		return modifiedEmployee.getAddressList();
	}
 
	@Override
	public EmployeeAddress updateEmployeeAddress(Long empId, Long addressId, EmployeeAddress address) {
		
		return null;
	}

	@Override
	public void deleteEmployeAddress(Long empId, Long addressId) {
		employeeAddressRepository.deleteById(addressId);
	}

	@Override
	public EmployeeAddress getEmployeeAddressByAddressId(Long addressId) {
		return employeeAddressRepository.findById(addressId).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<EmployeeAddress> getEmployeeAddressListByEmployeeId(Long empId) {
		Employee employee = employeeRepository.findById(empId).orElseThrow(EntityNotFoundException::new);
		return employee.getAddressList();
	}

	

}
