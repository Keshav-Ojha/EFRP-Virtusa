package com.keshav.employeemanagement.service;

import java.util.List;

import com.keshav.employeemanagement.dto.EmployeeDto;

public interface EmployeeService {
	
	public String addEmployee(EmployeeDto employee);
	public String updateEmployee(Long employeeId,EmployeeDto employee);
	public EmployeeDto getEmployeeById(Long id);
	public List<EmployeeDto> getAllEmployees();
	public String deleteEmployee(Long id);
	

}
