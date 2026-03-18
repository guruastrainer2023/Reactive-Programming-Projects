package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Employee;
import com.training.service.EmployeeService;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping(value = "/add")
	public Employee f1(@RequestBody Employee employee) {
		return this.service.addEmployee(employee);
	}

	@PutMapping(value = "/update")
	public Employee f2(@RequestBody Employee employee) {
		return this.service.updateEmployee(employee);
	}

	@DeleteMapping(value = "/delete")
	public boolean f3(@RequestBody Employee employee) {
		return this.service.deleteEmployee(employee);
	}

	@GetMapping(value = "/find/{eid}")
	public Employee f4(@PathVariable(name = "eid") int id) {
		return this.service.findEmployee(id);
	}

	@GetMapping(value = "/findAll")
	public List<Employee> f5() {
		return this.service.getAllEmployees();
	}

	@GetMapping(value = "/findAll1")
	public Page<Employee> f6(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "true") boolean ascending) {
		
		Sort sort=ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable=PageRequest.of(page, size, sort);
		return this.service.getAllEmployeesWithPagination(pageable);
	}
	
	@GetMapping(value="/findAll1")
	public Page<Employee> f7(int page, int size, String sortBy, boolean ascending){
		
	}

}
