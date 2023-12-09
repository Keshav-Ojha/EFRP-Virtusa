package com.kafka.KafkaDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.KafkaDemo.service.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class HomeController {

	@Autowired
	private KafkaProducer kafkaProducer;
	
	@GetMapping("/publish")
	public String publish(@RequestParam("message") String message) {
		kafkaProducer.sendMesssage(message);
		return "Message published to kafka topic";
	}
}
