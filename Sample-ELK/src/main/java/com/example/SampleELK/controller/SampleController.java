package com.example.SampleELK.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/elk")
@Slf4j
public class SampleController {

	@PostMapping("/payment")
	public String makePayment() {
		try {
			log.info("Payment initiated");
			throw new RuntimeException("Not sufficent balance");
		}catch(Exception e) {
			log.error("Error occured while making paymennt : " + e.getMessage());
		}
		return "Payment success";
	}
}
