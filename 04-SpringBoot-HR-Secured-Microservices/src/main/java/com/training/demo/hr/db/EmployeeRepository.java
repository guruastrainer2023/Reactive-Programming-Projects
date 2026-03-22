package com.training.demo.hr.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.demo.hr.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
