package com.training.demo.db;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.training.demo.bean.Employee;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String>{

}
