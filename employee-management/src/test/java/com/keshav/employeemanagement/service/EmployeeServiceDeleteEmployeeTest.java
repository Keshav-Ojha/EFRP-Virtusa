package com.keshav.employeemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.dao.DataAccessException;

import com.keshav.employeemanagement.entity.Employee;

public class EmployeeServiceDeleteEmployeeTest extends EmployeeServiceTest {

	@Test
	void testDeleteEmployee_Success() {
		Long id = 1L;
        Employee employee = new Employee();
        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        
        String result = employeeServiceImpl.deleteEmployee(id);

        
        verify(employeeRepository).delete(employee);
        assertEquals("Successfully deleted employee with id: "+id, result);
	}
	
	@Test
	void testDeleteEmployee_EmployeeNotFoundException() {
		Long id = 1L;
		
		when(employeeRepository.findById(id)).thenThrow(new EntityNotFoundException());
		
		assertThrows(EntityNotFoundException.class, ()->{
			employeeServiceImpl.deleteEmployee(id);
		});
	}
	
	@Test
	void testDeleteEmployee_Error() {
		Long id = 1L;
		
		Employee employee = new Employee();
		employee.setId(id);
		
		when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
		
		doThrow(new DataAccessException("test exception") {}).when(employeeRepository).delete(employee);
		
		RuntimeException exception = assertThrows(RuntimeException.class, ()-> {
			employeeServiceImpl.deleteEmployee(id);
		});
		
		assertEquals("Error deleting employee with id: " + id,exception.getMessage());
	}

}
