package com.training.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcomeapi")
public class WelcomeController {

	@GetMapping("/welcome")
	public String hello() {
		return "WELCOME";
	}

}
