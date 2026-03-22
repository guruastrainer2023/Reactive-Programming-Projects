package com.training.demo.hr.rs.response.department;

import java.util.List;

import com.training.demo.hr.bean.Department;

public class DepartmentRetrieveAllResponse {

	private int statusCode;
	private String message;
	private List<Department> allDepartments;
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
	public List<Department> getAllDepartments() {
		return allDepartments;
	}
	public void setAllDepartments(List<Department> allDepartments) {
		this.allDepartments = allDepartments;
	}
	
}
