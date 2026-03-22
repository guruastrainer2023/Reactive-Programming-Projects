package com.training.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1")
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
