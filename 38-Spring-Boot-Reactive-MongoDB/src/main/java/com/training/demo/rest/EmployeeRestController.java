package com.training.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.demo.bean.Employee;
import com.training.demo.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/add")
	public Mono<Employee> saveEmployee(@RequestBody   Employee employee){
		return this.service.addEmployee(employee);
	}
	
	@GetMapping("/find/{empid}")
	public Mono<Employee> findBydId(@PathVariable(name="empid")    String id){
		return this.service.getEmployeeById(id);
	}
	
	@GetMapping(path={"/all"})
	public Flux<Employee> findAllEmployees(){
		return this.service.getAllEmployees();
	}

}
