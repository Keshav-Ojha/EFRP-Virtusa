package com.kafka.KafkaDemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics="mySampleSpringBootTopic",groupId="group-id")
	public void consume(String message) {
		logger.info(String.format("Meesage received -> %s", message));
	}

}
