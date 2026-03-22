package com.training.demo.hr.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.demo.hr.bean.Department;

@Repository
public interface DepartmentRepositoy extends JpaRepository<Department, Integer>{

	 
}
