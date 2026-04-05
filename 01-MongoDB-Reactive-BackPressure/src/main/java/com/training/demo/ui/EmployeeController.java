package com.training.demo.ui;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.demo.bean.Employee;
import com.training.demo.db.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employeeapi")

public class EmployeeController {

	@Autowired
	private EmployeeRepository repository; 
	
	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> streamUsers() {
		
        return repository.findAll()
         .delayElements(Duration.ofMillis(5000)) // Artificial delay to simulate slow consumer
         .limitRate(2) // BACKPRESSURE: Request only 5 elements at a time from MongoDB
         .log(); // Logs the request(n) signals to see backpressure in action
    }
	
	@PostMapping("/add")
	public Mono<Employee> addEmployee(@RequestBody Employee employee){
		return this.repository.save(employee);
	}
}
