package com.training.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	 @GetMapping("/hello")
	    public String hello() {
	        return "Hello, World!";
	    }
}
