package com.training.demo.service;

import com.training.demo.bean.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
	Mono<Student> saveStudent(Student student); 
    Flux<Student> getAllStudents(); 
    Mono<Student> getStudentById(String id); 
    Mono<Void> deleteStudent(String id); 
}
