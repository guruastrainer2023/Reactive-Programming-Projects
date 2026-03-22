package com.training.demo.dao;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.training.demo.bean.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
