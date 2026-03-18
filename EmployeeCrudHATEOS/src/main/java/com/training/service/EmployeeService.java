package com.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.db.EmployeeRepository;
import com.training.model.Employee;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	public Employee addEmployee(Employee employee) {
		System.out.println(employee+ "added");
		return this.repository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return this.repository.save(employee);
	}
	
	public Employee findEmployee(int id) {
		Optional<Employee> searchOptional= this.repository.findById(id);
		if(searchOptional.isPresent())
			return searchOptional.get();
		else
			return null;
	}
	
	public List<Employee> getAllEmployees(){
		System.out.println(this.repository.findAll());
		return this.repository.findAll();
	}
	
	public boolean deleteEmployee(Employee employee) {
		this.repository.delete(employee);
		return true;
	}
	
	
}
