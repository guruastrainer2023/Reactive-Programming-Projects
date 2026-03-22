package com.training.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.bean.Student;

public interface StudentDAO extends JpaRepository<Student, Integer>{

	List<Student> findStudentsByMarks(int mark);
	
}
