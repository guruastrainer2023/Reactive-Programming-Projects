package com.training.demo.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.demo.bean.Customer;

import jakarta.annotation.PostConstruct;

@Service
public class CustomerService {
	
	private List<Customer> customerList;
	
	@PostConstruct
	public void init() {
		if(customerList==null)
			this.customerList=new LinkedList<>();
		Customer customer1=new Customer(101, "John", "Mumbai");
		Customer customer2=new Customer(102, "Leena", "Patna");
		Customer customer3=new Customer(103, "Arnab", "Kolkata");
		
		this.customerList.add(customer1);
		this.customerList.add(customer2);
		this.customerList.add(customer3);
		
	}
	
	public List<Customer> getAllCustomers(){
		return this.customerList;
	}
	
	public Customer getCustomerById(int id) {
		Customer customer=new Customer(id);
		int index=this.customerList.indexOf(customer);
		if(index>=0)
			return this.customerList.get(index);
		return null;
	}

}
