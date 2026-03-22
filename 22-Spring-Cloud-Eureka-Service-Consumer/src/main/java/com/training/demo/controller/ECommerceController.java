package com.training.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.demo.bean.Customer;

@RestController
public class ECommerceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/allCustomers")
	public List<Customer> findAll() {
		String url="http://CUSTOMERSERVICE/customers/allCustomers";
		List<Customer> response=this.restTemplate.getForObject(url, List.class);
		return response;
	}
	
	/*@GetMapping("/findCustomer/{num}")
	public ResponseEntity<Customer> findById(@PathVariable(name = "num") int id){
		
	}*/

}
