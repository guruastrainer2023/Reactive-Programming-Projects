package com.training.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="HelloInvokerService", url = "http://localhost:8081", path="helloapi")
public interface HelloInvokerService1 {
	
	@GetMapping("/hello1")
	public String sayHello();
	
	@PostMapping("/hello2/{nm}")
	public String sayHelloWithName(@PathVariable(name="nm")  String name);
	
}
