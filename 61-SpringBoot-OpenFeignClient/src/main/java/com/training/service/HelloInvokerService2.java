package com.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloInvokerService2 {
	
	@Autowired
	HelloInvokerService1 service1;
	
	public String sayHello() {
		return this.service1.sayHello();
	}
	
	public String sayHelloWithName(String name) {
		return this.service1.sayHelloWithName(name);
	}

}
