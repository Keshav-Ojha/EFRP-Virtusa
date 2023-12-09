package com.keshav.employeemanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.keshav.employeemanagement.dto.EmployeeDto;
import com.keshav.employeemanagement.entity.Employee;
import com.keshav.employeemanagement.exceptions.EmployeeCreationException;
import com.keshav.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	private final ModelMapper modelMapper;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository,ModelMapper modelMapper) {
		this.employeeRepository = employeeRepository;
		this.modelMapper = modelMapper;
	}
	
	

	@Override
	public String addEmployee(EmployeeDto employeeDto) {
		
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		
		Employee createdEmployee = null;
		
		try {
			createdEmployee = employeeRepository.save(employee);
		}
		catch(Exception e) {
			throw new EmployeeCreationException("Failed to create new employee");
		}
		return "Successfuly create employee with id : " + createdEmployee.getId();
	}

	@Override
	public String updateEmployee(Long employeeId,EmployeeDto employee) {
		Employee updatedEmployee = modelMapper.map(employee, Employee.class);
		updatedEmployee.setId(employeeId);
		try {
			employeeRepository.save(updatedEmployee);
		}
		catch(Exception e) {
			throw new RuntimeException("Error while trying to update employee with id: " + employeeId);
		}
		return "Successfuly update employee with id: " + employeeId;
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Employee employee = null;
		try {
			employee = employeeRepository.getReferenceById(id);
		}
		catch(Exception e) {
			throw new RuntimeException("Could not get employee");
		}
		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		try {
		return employeeRepository.findAll().stream()
				.map(employee -> modelMapper.map(employee, EmployeeDto.class))
				.collect(Collectors.toList());
		}
		catch(Exception e) {
			throw new RuntimeException("Some error occured while trying to fetch all the employees list refer logs for more details");
		}
	}

	@Override
	public String deleteEmployee(Long id) {
		try {
	        Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));

	        employeeRepository.delete(employee);
	        
	        return "Successfully deleted employee with id: " + id;
	    } catch (EntityNotFoundException ex) {
	        throw ex;
	    } catch (DataAccessException ex) {
	        throw new RuntimeException("Error deleting employee with id: " + id);
	    }
	}

}
