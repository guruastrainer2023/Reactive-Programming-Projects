package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.db.PersonRepository;
import com.example.demo.model.Person;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	public Person addPerson(Person person) {
		return this.repository.save(person);
	}
	
	public List<Person> getAllPersons(){
		return this.repository.findAll();
	}

}
