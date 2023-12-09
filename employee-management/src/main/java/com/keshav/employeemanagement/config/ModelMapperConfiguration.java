package com.keshav.employeemanagement.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.keshav.employeemanagement.util.DateToStringConverter;
import com.keshav.employeemanagement.util.StringToDateConverter;


@Configuration
public class ModelMapperConfiguration {
	
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.addConverter(new StringToDateConverter());
		modelMapper.addConverter(new DateToStringConverter());
		
		return modelMapper;
	}	
}
	
