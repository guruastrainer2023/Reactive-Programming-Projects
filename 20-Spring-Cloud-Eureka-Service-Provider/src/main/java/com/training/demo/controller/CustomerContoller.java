package com.training.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.demo.bean.Customer;
import com.training.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerContoller {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allCustomers")
	public List<Customer>findAll() {
		List<Customer> allCustomers=this.customerService.getAllCustomers();
		return allCustomers;
	}
	
	@GetMapping("/findCustomer/{num}")
	public ResponseEntity<Customer> findById(@PathVariable(name = "num") int id){
		Customer customer=this.customerService.getCustomerById(id);
		return ResponseEntity.ok(customer);
	}

}
