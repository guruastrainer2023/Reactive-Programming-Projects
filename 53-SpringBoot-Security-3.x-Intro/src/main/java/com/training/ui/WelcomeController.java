package com.training.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public String f1() {
		return "WELCOME";
	}
	
	@GetMapping("/hello")
	public String f2() {
		return "HELLO";
	}
	
	@GetMapping("/greet")
	public String f3() {
		return "How are you?";
	}
}
