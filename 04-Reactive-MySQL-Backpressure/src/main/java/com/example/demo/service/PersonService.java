package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.db.PersonRepository;
import com.example.demo.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	public Mono<Person> addPerson(Person person) {
		return this.repository.save(person);
	}
	
	public Flux<Person> getAllPersons(){
		return this.repository.findAll();
	}

}
