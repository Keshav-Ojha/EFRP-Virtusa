package com.keshav.employeemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keshav.employeemanagement.dto.EmployeeDto;
import com.keshav.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{id}")
	public EmployeeDto getEmployeeId(@PathVariable("id") Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/")
	public String addEmployee(@RequestBody EmployeeDto employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/all")
	public List<EmployeeDto> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PutMapping("/{id}")
	public String updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto ) {
		return employeeService.updateEmployee(id, employeeDto);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
	}
}
