package com.training.demo.hr.rs.response.employee;

import com.training.demo.hr.bean.Employee;

public class EmployeeDeleteResponse {

	private int statusCode;
	private String message;
	private Employee employee;
	public EmployeeDeleteResponse(int statusCode, String message, Employee employee) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.employee = employee;
	}
	public EmployeeDeleteResponse() {
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
