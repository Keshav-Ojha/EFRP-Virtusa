package com.keshav.employeemanagement.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.keshav.employeemanagement.dto.EmployeeDto;
import com.keshav.employeemanagement.entity.Employee;

public class EmployeeServiceGetEmployeeTest extends EmployeeServiceTest{
	
	
	@Test
	void testGetEmployeeById_Success() {
		Employee employee = new Employee();
		
		when(employeeRepository.getReferenceById(1L)).thenReturn(employee);
		
		when(modelMapper.map(employee,EmployeeDto.class)).thenReturn(new EmployeeDto());
		
		assertNotNull(employeeServiceImpl.getEmployeeById(1L));
		
	}
	
	@Test
    public void testGetEmployeeById_Exception() {
        Long id = 1L;
        when(employeeRepository.getReferenceById(id)).thenThrow(new RuntimeException("Could not get employee"));

        assertThrows(RuntimeException.class, () -> {
            employeeServiceImpl.getEmployeeById(id);
        });
    }
}
