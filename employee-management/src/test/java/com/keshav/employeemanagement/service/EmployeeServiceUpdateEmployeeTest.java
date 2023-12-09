package com.keshav.employeemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.keshav.employeemanagement.dto.EmployeeDto;
import com.keshav.employeemanagement.entity.Employee;

public class EmployeeServiceUpdateEmployeeTest extends EmployeeServiceTest{
	
	@Test
	void testUpdateEmployee_Success() {
		Long id = 1L;
		EmployeeDto employeeDto = new EmployeeDto();
		Employee mappedEmployee = new Employee();
		Employee updatedEmployee = new Employee();
		updatedEmployee.setId(id);
		
		when(modelMapper.map(employeeDto, Employee.class)).thenReturn(mappedEmployee);
		when(employeeRepository.save(mappedEmployee)).thenReturn(updatedEmployee);
		
		String result = employeeServiceImpl.updateEmployee(id, employeeDto);
		
		assertEquals("Successfuly update employee with id: " + id, result);
	}
	
	@Test
	void testUpdateEmployee_Exception() {
		
		Long id = 1L;
		EmployeeDto employeeDto = new EmployeeDto();
		Employee mappedEmployee = new Employee();
		
		when(modelMapper.map(employeeDto,Employee.class)).thenReturn(mappedEmployee);
		when(employeeRepository.save(mappedEmployee)).thenThrow(RuntimeException.class);
		
		assertThrows(RuntimeException.class, ()->employeeServiceImpl.updateEmployee(id, employeeDto));
	}

}
