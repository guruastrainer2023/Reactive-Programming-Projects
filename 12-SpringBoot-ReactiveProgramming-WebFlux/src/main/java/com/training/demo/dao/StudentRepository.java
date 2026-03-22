package com.training.demo.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import com.training.demo.bean.Student;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student, String>{
	

}
