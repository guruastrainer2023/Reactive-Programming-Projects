package com.training.demo.hr.rs.request.department;

import com.training.demo.hr.bean.Department;

public class DepartmentDeleteRequest {
	private int id;
	private Department department;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
