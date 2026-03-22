package com.training.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloapi")
public class HelloService {
	
	@GetMapping("/hello")
	public String hello() {
		return "HELLO";
	}

}
