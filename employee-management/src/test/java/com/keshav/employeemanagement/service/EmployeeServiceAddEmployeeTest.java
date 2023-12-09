package com.keshav.employeemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.keshav.employeemanagement.dto.EmployeeDto;
import com.keshav.employeemanagement.entity.Employee;
import com.keshav.employeemanagement.exceptions.EmployeeCreationException;

public class EmployeeServiceAddEmployeeTest extends EmployeeServiceTest{
	
	private Employee mappedEmployee;
	
	private EmployeeDto  employeeDto;
	
	@BeforeEach
	void setUp() {
		
		super.setUp();
		
		EmployeeDto employeeDto = new EmployeeDto();
		Employee mappedEmployee = new Employee();
		
		when(modelMapper.map(employeeDto, Employee.class)).thenReturn(mappedEmployee);
		when(modelMapper.map(mappedEmployee, EmployeeDto.class)).thenReturn(employeeDto);
	}
	
	@Test
	void testAddEmployee_Successful() {
		
		Employee savedEmployee = new Employee();
		
		savedEmployee.setId(1L);
		
		when(employeeRepository.save(mappedEmployee)).thenReturn(savedEmployee);
		
		String result = employeeServiceImpl.addEmployee(employeeDto);
		
		assertEquals("Successfuly create employee with id : 1",result);
	}
	
	@Test
	void testAddEmployee_Failure() {
		Employee savedEmployee = new Employee();
		
		savedEmployee.setId(1L);
		
		when(employeeRepository.save(mappedEmployee)).thenThrow(new RuntimeException("Error adding employee"));
		
		assertThrows(EmployeeCreationException.class, ()->employeeServiceImpl.addEmployee(employeeDto));
		
	}
}
