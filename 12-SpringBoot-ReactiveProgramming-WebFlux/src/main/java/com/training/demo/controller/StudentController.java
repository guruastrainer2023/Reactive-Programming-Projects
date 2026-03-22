package com.training.demo.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.demo.bean.Student;
import com.training.demo.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/students") 
public class StudentController { 
  
	@Autowired
    private StudentService studentService; 
  
    
	@PostMapping("/update")
    public Mono<Student>    saveStudent(@RequestBody Student student) 
    { 
        return studentService.saveStudent(student); 
    } 
  
    @GetMapping("/findAll")
    public Flux<Student> getAllStudents() 
    { 
        return studentService.getAllStudents().delayElements(Duration.ofSeconds(1))
				.doOnNext(System.out::println)
				.map(i->i);
    } 
  
    @GetMapping("/find/{id}") 
    public Mono<Student> getStudentById(@PathVariable String id) 
    { 
        return studentService.getStudentById(id); 
    } 
    @PostMapping("/create")
    public Mono<Student> createStudent(@RequestBody Student student) 
    { 
        return studentService.saveStudent(student); 
    } 
  
    @DeleteMapping("/{id}") 
    public Mono<Void> deleteStudent(@PathVariable String id) 
    { 
        return studentService.deleteStudent(id); 
    } 
}