package com.training.demo.rest.constroller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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
import com.training.demo.dto.EmployeeActionDTO;
import com.training.demo.service.KafkaProducerService;

@RestController
@RequestMapping("/emp")
public class EmployeeSenderController {
	
	
	@Autowired
	private KafkaProducerService producerService;
	
	
	@PostMapping("/action")
	public ResponseEntity<EmployeeActionDTO> publish(@RequestBody EmployeeActionDTO actionDTO) throws InterruptedException, ExecutionException{
		 producerService.sendEmployeeActionMessage(actionDTO);
		 return ResponseEntity.ok(actionDTO);
	}

}
