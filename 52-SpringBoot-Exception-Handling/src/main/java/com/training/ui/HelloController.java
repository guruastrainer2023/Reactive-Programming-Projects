package com.training.ui;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@RequestMapping("/hello")
	public String f1() {
		return "Hello Welcome to Spring Boot";
	}
	
	@RequestMapping(value="/greet", method = RequestMethod.GET)
	public String f2() {
		return "Hi..How Are You ?";
				
	}

}
