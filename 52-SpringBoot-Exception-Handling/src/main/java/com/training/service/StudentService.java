package com.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.bean.Student;
import com.training.dao.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	
	public Student createStudent(Student student) {
		Student student1=this.repository.save(student);
		return student1;
	}
	
	public Student getStudentByRollNumber(int rollNumber) {
		Optional<Student> optional=this.repository.findById(rollNumber);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public List<Student> getAllStudents(){
		List<Student> allStudents=this.repository.findAll();
		return allStudents;
	}
	
	public Student updateStudent(Student student) {
		Student student1=this.repository.save(student);
		return student1;
	}
	
	public String deleteStudentByRollNumber(int rollNumber) {
		this.repository.deleteById(rollNumber);
		return "SUCCESS";
		
	}
	
	public List<Student> getAllStudentsByName(String name){
		List<Student> allStudents=this.repository.findByName(name);
		return allStudents;
	}
	
	public List<Student> getAllStudentsByMarks(int mark){
		List<Student> allStudents=this.repository.findByMark3(mark);
		return allStudents;
	}
	
	public List<Student> getAllStudentsByMark2Above(int mark){
		List<Student> allStudents=this.repository.findStudentsByMark2(mark);
		return allStudents;
	}

}
