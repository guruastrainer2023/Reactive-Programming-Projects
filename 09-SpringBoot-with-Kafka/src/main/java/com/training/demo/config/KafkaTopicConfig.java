package com.training.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	@Bean
	public NewTopic createTopic() {
		System.out.println("Employee Topic Created");
		return TopicBuilder.name("EmployeeTopic").build();
	}

}
