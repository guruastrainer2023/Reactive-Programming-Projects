package com.training.demo.dto;

import com.training.demo.bean.Employee;

public class EmployeeActionDTO {
	private Action requestAction;
	private String responseString;
	private Employee employee;
	
	public EmployeeActionDTO(Action requestAction, String responseString, Employee employee) {
		super();
		this.requestAction = requestAction;
		this.responseString = responseString;
		this.employee = employee;
	}
	public EmployeeActionDTO() {
		super();
	}
	public Action getRequestAction() {
		return requestAction;
	}
	public void setRequestAction(Action requestAction) {
		this.requestAction = requestAction;
	}
	public String getResponseString() {
		return responseString;
	}
	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "EmployeeActionDTO [requestAction=" + requestAction + ", responseString=" + responseString
				+ ", employee=" + employee + "]";
	}
	
	
	

}
