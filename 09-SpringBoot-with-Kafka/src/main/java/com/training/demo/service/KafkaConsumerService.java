package com.training.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.training.demo.bean.Employee;

@Service
public class KafkaConsumerService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaConsumerService.class);

	@KafkaListener(topics = "EmployeeTopic", groupId = "MyGroup")
	public void comsumeEmployee(Employee employee) {
		LOGGER.info("Employee Received -> "+ employee);
	}
}
