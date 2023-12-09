package com.keshav.employeemanagement.service;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import com.keshav.employeemanagement.repository.EmployeeRepository;

public class EmployeeServiceTest {
	
	public EmployeeServiceImpl employeeServiceImpl;
	
	public ModelMapper modelMapper = Mockito.mock(ModelMapper.class);
	
	public EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
	
	@BeforeEach
	void setUp() {
		employeeServiceImpl = new EmployeeServiceImpl(employeeRepository,modelMapper);
	}

}
