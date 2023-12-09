package com.kafka.KafkaDemo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    NewTopic getNewTopic() {
		return TopicBuilder.name("mySampleSpringBootTopic").build();
				
	}

}
