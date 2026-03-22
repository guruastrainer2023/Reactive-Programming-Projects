package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Sending {
	
	@Autowired 
	private RabbitMQProducer rabbitMQProducer;
	
	
	@PostConstruct
	void start() {
		
		rabbitMQProducer.sendMessage("connected to RabbitMQ!");
	}

}
