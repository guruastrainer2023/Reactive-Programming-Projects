package com.training.demo.hr.rs.response.department;

import com.training.demo.hr.bean.Department;

public class DepartmentUpdateResponse {
	private int statusCode;
	private String message;
	private Department department;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
