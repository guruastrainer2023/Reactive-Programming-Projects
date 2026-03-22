package com.training.demo.hr.service.employee;

import java.util.List;

import com.training.demo.hr.bean.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee Employee) throws Exception;
	Employee updateEmployee(Employee Employee) throws Exception;
	boolean deleteEmployee(Employee Employee) throws Exception;
	Employee getEmployeeById(int id) throws Exception;
	List<Employee> getAllEmployees() throws Exception;

}
