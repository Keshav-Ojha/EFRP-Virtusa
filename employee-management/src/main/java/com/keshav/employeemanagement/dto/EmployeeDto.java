package com.keshav.employeemanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDto {

	private String firstName;
	private String lastName;
	private String email;
	private String department;
	private String joiningDate;
}
