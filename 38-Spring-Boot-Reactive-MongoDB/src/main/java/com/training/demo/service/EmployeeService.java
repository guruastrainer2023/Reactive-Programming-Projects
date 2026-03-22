package com.training.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.DeleteResult;
import com.training.demo.bean.Employee;
import com.training.demo.dao.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private ReactiveMongoTemplate template;
	
	public Mono<Employee> addEmployee(Employee employee){
		if(employee==null) return null;
		else {
			return this.template.insert(employee);
		}
	}
	
	public Mono<Employee> getEmployeeById(String id){
		return this.template.findById(id, Employee.class);
		//return this.repository.findById(id);
	}
	
	public Flux<Employee> getAllEmployees(){
		
		return this.template.findAll(Employee.class).limitRate(5);
		//return this.repository.findAll();
	}
	
	public Mono<DeleteResult> deleteById(String id) {
		return this.template.remove(new Employee(id));
		//return this.repository.deleteById(id);
	}
	
}
