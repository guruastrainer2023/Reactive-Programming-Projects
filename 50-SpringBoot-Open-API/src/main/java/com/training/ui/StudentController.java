package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.Student;
import com.training.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	
	@Operation(summary = "Get a Student by its id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the Student", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Student.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid Roll Number supplied", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Student not found", 
	    content = @Content) })
	
	@GetMapping("/get/{sid}")
	public Student f1(@PathVariable("sid")  int id) {
		return this.service.getStudentById(id);
	}
	
	@Operation(summary = "Get all Students")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Found all the Students", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Student.class)) })})
			
	@GetMapping("/all")
	public List<Student> f2(){
		return this.service.getAllStudents();
	}
	
	//add
	@PostMapping("/add")
	public Student f3(@PathVariable   Student student) {
		return this.service.addStudent(student);
	}
	
	//add
	@PutMapping("/update")
	public Student f4(@PathVariable   Student student) {
		return this.service.updateStudent(student);
	}
	
	//add
	@DeleteMapping("/delete")
	public String f5(@PathVariable   Student student) {
		this.service.deleteStudent(student);
		return "success";
	}

}
