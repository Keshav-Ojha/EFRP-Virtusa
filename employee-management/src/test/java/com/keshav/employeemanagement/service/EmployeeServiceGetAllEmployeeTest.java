package com.keshav.employeemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.keshav.employeemanagement.dto.EmployeeDto;
import com.keshav.employeemanagement.entity.Employee;

public class EmployeeServiceGetAllEmployeeTest extends EmployeeServiceTest {
	
	private Employee employee;
	private EmployeeDto mappedEmployee;
	private List<Employee> employeeList;
	private List<EmployeeDto> mappedEmployeeList;
	
	@BeforeEach
	void setUp() {
		super.setUp();
		employee = new Employee();
		employee.setFirstName("keshav");
		
		mappedEmployee = new EmployeeDto();
		mappedEmployee.setFirstName("keshav");
		
		employeeList= new ArrayList<>();
		employeeList.add(employee);

		mappedEmployeeList = new ArrayList<>();
		mappedEmployeeList.add(mappedEmployee);
	}

	@Test
	void testGetAllEmployees_Success() {
		
		when(employeeRepository.findAll()).thenReturn(employeeList);
		
		when(modelMapper.map(employee,EmployeeDto.class)).thenReturn(mappedEmployee);
		
		assertEquals(mappedEmployeeList, employeeServiceImpl.getAllEmployees());
	}
	
	@Test
	void testGetAllEmployees_Exception() {
		
	}

}
