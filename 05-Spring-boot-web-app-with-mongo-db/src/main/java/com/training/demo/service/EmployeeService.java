package com.training.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.demo.bean.Employee;
import com.training.demo.dao.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee addEmployee(Employee employee) {
		
		Employee newEmp=this.repository.save(employee);
		return newEmp;
	}
	
	public Employee searchById(String id) {
		Employee employee=this.repository.findById(id).get();
		return employee;
	}
	
	public List<Employee> getAllEmployees(){
		return this.repository.findAll();
	}
	
	public String deleteById(String id) {
		this.repository.deleteById(id);
		return "Employee Deleted Successfully";
	}
	
	public Employee updateEmployee(Employee employee) {
		Employee employee1=this.repository.findById(employee.getId()).get();
		
		employee1.setName(employee.getName());
		employee1.setBasicSalary(employee.getBasicSalary());
		employee1.setDepartmentName(employee.getDepartmentName());
		employee1.setDateOfJoin(employee.getDateOfJoin());
		employee1.setGender(employee.getGender());
		employee.setReadyToTravel(employee.isReadyToTravel());
		
		employee1=this.repository.save(employee1);
		return employee1;
	
	}
	

}
