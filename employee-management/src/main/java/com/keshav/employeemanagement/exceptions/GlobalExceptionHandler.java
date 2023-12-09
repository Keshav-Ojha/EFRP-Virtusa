package com.keshav.employeemanagement.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public String employeeCreationException(EmployeeCreationException exception) {
		
		return exception.getMessage();
	}

}
