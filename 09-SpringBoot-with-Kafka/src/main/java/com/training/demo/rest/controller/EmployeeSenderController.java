package com.training.demo.rest.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.demo.bean.Employee;
import com.training.demo.service.KafkaProducerService;

@RestController
@RequestMapping("/emp")
public class EmployeeSenderController {
	
	
	@Autowired
	private KafkaProducerService producerService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Employee> publish(@RequestBody Employee employee){
		
		
		 this.producerService.sendEmployeeMessage(employee);
		 return ResponseEntity.ok(employee);
	}

}
