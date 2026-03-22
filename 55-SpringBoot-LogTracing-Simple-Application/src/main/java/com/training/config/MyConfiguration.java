package com.training.config;

import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@Configuration
public class MyConfiguration {

	
	@Bean
	
	public RestTemplate f1(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	 @Bean
	    public Sampler alwaysSampler() {
	        return Sampler.ALWAYS_SAMPLE;
	    }
}
