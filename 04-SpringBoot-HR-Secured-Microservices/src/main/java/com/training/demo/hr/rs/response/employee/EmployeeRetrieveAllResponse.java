package com.training.demo.hr.rs.response.employee;

import java.util.List;

import com.training.demo.hr.bean.Employee;


public class EmployeeRetrieveAllResponse {
	
	private int statusCode;
	private String message;
	private List<Employee> allEmployees;
	
	public EmployeeRetrieveAllResponse(int statusCode, String message, List<Employee> allEmployees) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.allEmployees = allEmployees;
	}
	public EmployeeRetrieveAllResponse() {
		super();
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Employee> getAllEmployees() {
		return allEmployees;
	}
	public void setAllEmployees(List<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}
	
	
}
