package com.training.demo.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.training.demo.bean.Employee;
import com.training.demo.dto.EmployeeActionDTO;

@Service
public class KafkaProducerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

	private KafkaTemplate<String, EmployeeActionDTO> kafkaTemplate;

	public KafkaProducerService(KafkaTemplate<String, EmployeeActionDTO> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendEmployeeActionMessage(EmployeeActionDTO actionDTO) {
		LOGGER.info("Employee Action Object Sent -> " + actionDTO);
		// kafkaTemplate.send("EmployeeActionTopic", actionDTO);
		//Future<SendResult<String, EmployeeActionDTO>> future;
		//CompletableFuture<SendResult<String, EmployeeActionDTO>> future;
		SendResult<String, EmployeeActionDTO> sendResult=new SendResult<>(new ProducerRecord("EmployeeActionTopic", actionDTO), null);
		//ProducerRecord<String, EmployeeActionDTO> pr=new ProducerRecord<>("EmployeeActionTopic", actionDTO);
		
			this.kafkaTemplate.send("EmployeeActionTopic", actionDTO).complete(sendResult);
			
			Employee employee=sendResult.getProducerRecord().value().getEmployee();
			actionDTO.setEmployee(employee);
			System.out.println("Employee DTO after sync call : "+ employee);
		
		//ProducerRecord<String, EmployeeActionDTO> pr = sendResult.getProducerRecord();
	
		//return CompletableFuture.completedFuture(actionDTO);

	}

}
