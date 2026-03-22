package com.training.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.training.service.HelloInvokerService2;

@RestController

public class HelloInvokerController {

	@Autowired
	HelloInvokerService2 service;
	
	@GetMapping("/invoke1")
	public String f1() {
		return this.service.sayHello();
	}
	
	@GetMapping("/invoke2/{nm}")
	public String f2(@PathVariable(name="nm") String name) {
		return this.service.sayHelloWithName(name);
	}
}
