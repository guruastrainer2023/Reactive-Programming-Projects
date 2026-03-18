package com.training.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.Employee;

@Repository
public interface EmployeeRepository extends  JpaRepository<Employee, Integer>{

}
