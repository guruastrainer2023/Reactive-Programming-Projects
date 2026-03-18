package com.training.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig implements WebMvcConfigurer{

	
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/api/**") // Apply this to all API paths
	                .allowedOrigins("http://localhost:4200") // The URL of your Angular app
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
	                .allowedHeaders("*") // Allow all headers
	                .allowCredentials(true) // Allow credentials (cookies, authorization headers)
	                .maxAge(3600); // Cache preflight requests for 1 hour
	    }
}
