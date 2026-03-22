package com.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.bean.Student;
import com.training.dao.StudentDAO;

@Service
public class StudentService {
	
	@Autowired
	StudentDAO dao;

	public Student getStudentById(int id) {
		Optional<Student> optionalStudent= this.dao.findById(id);
		if(optionalStudent.isPresent())
			return optionalStudent.get();
		else
			return null;
	}
	
	public List<Student> getAllStudents(){
		return this.dao.findAll();
	}
	
	public List<Student> getAllStudentsByMark(int mark){
		return this.dao.findStudentsByMarks(mark);
	}
	
	public Student addStudent(Student student) {
		return this.dao.save(student);
	}
	
	public void deleteStudent(Student student) {
		this.dao.delete(student);
	}
}
