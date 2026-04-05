package com.training.demo.bean;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Employees")
public class Employee {
	
	@Id
	private String _id;
	private String name;
	private String gender;
	private double basicSalary;
	private LocalDate dateOfJoin;
	private String departmentName;
	private boolean readyToTravel;
	
	public Employee(String id, String name, String gender, double basicSalary, LocalDate dateOfJoin,
			String departmentName, boolean readyToTravel) {
		super();
		this._id = id;
		this.name = name;
		this.gender = gender;
		this.basicSalary = basicSalary;
		this.dateOfJoin = dateOfJoin;
		this.departmentName = departmentName;
		this.readyToTravel = readyToTravel;
	}

	public Employee() {
		super();
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public boolean isReadyToTravel() {
		return readyToTravel;
	}

	public void setReadyToTravel(boolean readyToTravel) {
		this.readyToTravel = readyToTravel;
	}

	@Override
	public String toString() {
		return "Employee [id=" + _id + ", name=" + name + ", gender=" + gender + ", basicSalary=" + basicSalary
				+ ", dateOfJoin=" + dateOfJoin + ", departmentName=" + departmentName + ", readyToTravel="
				+ readyToTravel + "]";
	}
	
	
	
	

}
