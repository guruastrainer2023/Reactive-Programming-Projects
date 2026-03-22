package com.training.demo.hr.rs.request.employee;

import com.training.demo.hr.bean.Employee;

public class EmployeeDeleteRequest {
	private int id;
	private Employee employee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
