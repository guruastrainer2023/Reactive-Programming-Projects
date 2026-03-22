package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InvokerController {
	
	@Autowired
	RestTemplate template;

	@GetMapping("/invoke")
	public String invoke() {
		String url="http://welcomeservice/welcome";
		return this.template.getForObject(url, String.class);
	}
}
