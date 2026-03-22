package com.training.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.bean.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	public List<Student> findByName(String name);
	public List<Student> findByMark3(int mark);
	
	@Query("select s from Student s where s.mark2>?1")
	public List<Student> findStudentsByMark2(int mark);
	
}
