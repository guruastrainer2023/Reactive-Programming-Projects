package com.training.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.training.demo.bean.Employee;

@Service
public class KafkaProducerService {
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducerService.class);
	
	private KafkaTemplate<String, Employee> kafkaTemplate;

	public KafkaProducerService(KafkaTemplate<String, Employee> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendEmployeeMessage(Employee employee) {
		LOGGER.info("Employee Object Sent -> " + employee);
		kafkaTemplate.send("EmployeeTopic", employee);
		
	
	}

}
