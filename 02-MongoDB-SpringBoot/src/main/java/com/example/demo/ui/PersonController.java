package com.example.demo.ui;

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

@RestController
@RequestMapping("/personapi")
public class PersonController {
	
	@Autowired
	PersonService service;

	@PostMapping("/add")
	public Person f1(@RequestBody   Person person) {
		return this.service.addPerson(person);
				
	}
	
	@GetMapping(value="/fetchAll")
	public List<Person> f2(){
		return this.service.getAllPersons();
	}
}
