package com.kafka.KafkaDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMesssage(String message) {
		kafkaTemplate.send("mySampleSpringBootTopic",message);
	}
}
