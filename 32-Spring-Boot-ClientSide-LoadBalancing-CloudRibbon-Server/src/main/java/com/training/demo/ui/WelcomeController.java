package com.training.demo.ui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class WelcomeController {
	
	
	@Value("${server.port}")
	private String port;
	

	@GetMapping(value="/welcome")
	public String f1() {
		return "welcome from" + port;
	}
}
