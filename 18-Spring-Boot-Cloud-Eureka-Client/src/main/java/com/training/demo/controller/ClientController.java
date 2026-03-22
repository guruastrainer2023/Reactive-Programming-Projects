package com.training.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class ClientController {

	
	@Autowired
	private RestTemplateBuilder builder;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@RequestMapping("/callany")
	public String callService() {
		System.out.println("Client Controller Call Any");
		RestTemplate restTemplate=this.builder.build();
		InstanceInfo info=eurekaClient.getNextServerFromEureka("EurekaService", false);
		String url=info.getHomePageUrl();
		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return response.getBody();
	}
	
	
}
