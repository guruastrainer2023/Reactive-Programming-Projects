package com.training.service;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfiguration1 {

	@Bean
	public StudentService f1() {
		return new StudentService();
	};
	
}
