package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.Student;
import com.training.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/get/{sid}")
	public Student f1(@PathVariable("sid")  int id) {
		return this.service.getStudentById(id);
	}
	
	@GetMapping("/all")
	public List<Student> f2(){
		return this.service.getAllStudents();
	}

}
