package com.training.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.demo.bean.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer>{

}
