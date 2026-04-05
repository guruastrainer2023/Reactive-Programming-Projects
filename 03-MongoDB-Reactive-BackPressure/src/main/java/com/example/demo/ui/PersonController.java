package com.example.demo.ui;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personapi")
public class PersonController {
	
	@Autowired
	PersonService service;

	@PostMapping("/add")
	public Mono<Person> f1(@RequestBody   Person person) {
		return this.service.addPerson(person);
				
	}
	
	@GetMapping(value="/fetchAll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Person> f2(){
		 return service.getAllPersons()
		         .delayElements(Duration.ofMillis(5000)) // Artificial delay to simulate slow consumer
		         .limitRate(2) // BACKPRESSURE: Request only 5 elements at a time from MongoDB
		         .log(); // Logs the request(n) signals to see backpressure in action
	}
}
