package com.training.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.demo.bean.Employee;
import com.training.demo.dao.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Mono<Employee> addEmployee(Employee employee){
		if(employee==null) return null;
		else {
			return this.repository.insert(employee);
		}
	}
	
	public Mono<Employee> getEmployeeById(String id){
		return this.repository.findById(id);
	}
	
	public Flux<Employee> getAllEmployees(){
		return this.repository.findAll();
	}
	
	public Mono<Void> deleteById(String id) {
		return this.repository.deleteById(id);
	}
	
}
