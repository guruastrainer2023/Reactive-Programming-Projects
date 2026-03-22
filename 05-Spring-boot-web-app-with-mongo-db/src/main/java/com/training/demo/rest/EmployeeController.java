package com.training.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.demo.bean.Employee;
import com.training.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/addnew")
	public Employee addNewEmployee(@RequestBody Employee employee) {
		return this.service.addEmployee(employee);
	}
	
	@GetMapping("/getEmp/{empid}")
	public Employee getEmployeeUsingId(@PathVariable(name="empid") String id) {
		return this.service.searchById(id);
	}
	
	@GetMapping("/getall")
	public List<Employee> retriveAllEmployees(){
		return this.service.getAllEmployees();
	}
	
	@DeleteMapping("/remove")
	public String deleteEmployee(@RequestBody Employee employee) {
		return this.service.deleteById(employee.getId());
	}
	
	@PutMapping("/update")
	public Employee editEmployee(@RequestBody Employee employee) {
		return this.service.updateEmployee(employee);
	}

}
