package com.training.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.training.demo.bean.Employee;
import com.training.demo.dao.EmployeeRespository;
import com.training.demo.dto.EmployeeActionDTO;

@Service
public class KafkaConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

	@Autowired
	private EmployeeRespository respository;

	@KafkaListener(topics = "EmployeeActionTopic", groupId = "MyGroup")
	public void comsumeEmployeeAction(EmployeeActionDTO actionDTO) {
		Employee employee = null;
		LOGGER.info("Employee Action Received Received -> " + actionDTO);
		switch (actionDTO.getRequestAction()) {
		case ADD:
			employee = this.respository.save(actionDTO.getEmployee());
			System.out.println("After Saving "+ employee);
			actionDTO.setResponseString("Employee Added Successfully");
			actionDTO.setEmployee(employee);
			break;
		case UPDATE:
			employee = this.respository.findById(actionDTO.getEmployee().getId()).get();
			if (employee != null) {
				employee.setName(actionDTO.getEmployee().getName());
				employee.setBasicSalary(actionDTO.getEmployee().getBasicSalary());
				employee.setGender(actionDTO.getEmployee().getGender());
				employee.setDateOfJoin(actionDTO.getEmployee().getDateOfJoin());
				employee.setReadyToTravel(actionDTO.getEmployee().isReadyToTravel());
				employee = this.respository.save(employee);
				actionDTO.setResponseString("Employee Updated Successfully");

				actionDTO.setEmployee(employee);
			} else {
				actionDTO.setResponseString("Employee Not Updated");
				actionDTO.setEmployee(employee);
			}
			break;
		case FETCH:
			employee = this.respository.findById(actionDTO.getEmployee().getId()).get();
			if (employee != null)
				actionDTO.setResponseString("Employee Fetched Successfully");
			else
				actionDTO.setResponseString("Employee Not Fetched");
			actionDTO.setEmployee(employee);
			break;
		case DELETE:
			this.respository.delete(actionDTO.getEmployee());
			actionDTO.setResponseString("Employee Deleted Successfully");
			actionDTO.setEmployee(employee);
			break;

		}

	}
}
