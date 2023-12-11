package com.microservices.UserService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservices.UserService.exceptions.CustomErrorDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignConfiguration {

	@Bean
	public ErrorDecoder getErrorDecoder() {
		return new CustomErrorDecoder();
	}
}
