package com.training.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.demo.bean.Student;
import com.training.demo.dao.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository; 

	@Override
	public Mono<Student> saveStudent(Student student) {
		return studentRepository.save(student); 
	}

	@Override
	public Flux<Student> getAllStudents() {
		
		return studentRepository.findAll(); 
	}

	@Override
	public Mono<Student> getStudentById(String id) {
	
		return studentRepository.findById(id);
	}

	@Override
	public Mono<Void> deleteStudent(String id) {
		
		return studentRepository.deleteById(id);
	}

}
