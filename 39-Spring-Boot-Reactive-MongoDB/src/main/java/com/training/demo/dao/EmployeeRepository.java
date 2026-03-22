package com.training.demo.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.training.demo.bean.Employee;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

}
