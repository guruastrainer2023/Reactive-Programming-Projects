package com.training.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcomeapi")
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String f1() {
		return "WELCOME";
	}
	
	@PostMapping("/welcome/{name}")
	public String f2(@PathVariable(name="name")  String name) {
		return "Welcome "+ name.toUpperCase();
	}

}
