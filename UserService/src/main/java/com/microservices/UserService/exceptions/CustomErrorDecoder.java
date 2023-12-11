package com.microservices.UserService.exceptions;

import org.springframework.http.HttpStatus;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		if (response.status() == HttpStatus.NOT_FOUND.value()) {
            // Handle 404 Not Found error
            return new RuntimeException("Resource not found");
        } else if (response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            // Handle 500 Internal Server Error
            return new RuntimeException("Internal server error");
        }

        // Default behavior: throw FeignException with the original response
        return FeignException.errorStatus(methodKey, response);
	}

}
