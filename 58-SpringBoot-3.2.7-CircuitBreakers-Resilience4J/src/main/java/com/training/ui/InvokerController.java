package com.training.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api2")
public class InvokerController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/welcome")
	@CircuitBreaker(name = "serviceA", fallbackMethod = "f1")
	public String welcome() {
		String url="http://localhost:8081/api1/hello";
		String result=this.restTemplate.getForObject(url, String.class);
		return result.toUpperCase();
	}
	
	public String f1(Exception e) {
		return "Just";
	}

}
