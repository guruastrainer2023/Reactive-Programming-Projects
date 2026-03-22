package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.Student;
import com.training.service.StudentService;



@RestController
@RequestMapping("/studentapi")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/add")
	public Student f1(@RequestBody   Student student) {
		return this.service.createStudent(student);
	}

	
	
	@GetMapping("/get/{rollNumber}")
	public Student f2(@PathVariable(name="rollNumber")   int rollNumber) {
		return this.service.getStudentByRollNumber(rollNumber);
	}
	
	
	
	@GetMapping("/all")
	public List<Student> f3(){
		return this.service.getAllStudents();
	}
	
	@PutMapping("/update")
	public Student f4(@RequestBody  Student student) {
		return this.service.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{rn}")
	public String f5(@PathVariable(name="rn")   int rollNumber) {
		return this.service.deleteStudentByRollNumber(rollNumber);
	}
	
	@GetMapping("/all/name/{name}")
	public List<Student> f6(@PathVariable(name="name")  String name){
		return this.service.getAllStudentsByName(name);
	}
	
	@GetMapping("/all/mark3/{mark}")
	public List<Student> f7(@PathVariable(name="mark")  int mark){
		return this.service.getAllStudentsByMarks(mark);
	}
	

	@GetMapping("/all/mark2/above/{mark}")
	public List<Student> f8(@PathVariable(name="mark")  int mark){
		return this.service.getAllStudentsByMark2Above(mark);
	}
	
}
