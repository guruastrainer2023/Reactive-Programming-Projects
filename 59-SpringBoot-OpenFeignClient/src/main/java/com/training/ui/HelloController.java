package com.training.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloapi")
public class HelloController {
	
	@GetMapping("/hello1")
	public String f1() {
		return "HELLO";
	}
	
	@PostMapping("/hello2/{name}")
	public String f2(@PathVariable(name="name")  String name) {
		return "Hello "+ name.toUpperCase();
	}

}
