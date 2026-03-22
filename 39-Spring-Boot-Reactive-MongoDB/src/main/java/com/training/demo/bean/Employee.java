package com.training.demo.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employees")
public class Employee implements Serializable{
	
	@Id
	private String id;
	private String name;
	private Gender gender;
	private double basicSalary;
	private LocalDate dateOfJoin;
	private String departmentName;
	private boolean readyToTravel;
	
	public Employee(String id, String name, Gender gender, double basicSalary, LocalDate dateOfJoin,
			String departmentName, boolean readyToTravel) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.basicSalary = basicSalary;
		this.dateOfJoin = dateOfJoin;
		this.departmentName = departmentName;
		this.readyToTravel = readyToTravel;
	}
	public Employee(String name, Gender gender, double basicSalary, LocalDate dateOfJoin, String departmentName,
			boolean readyToTravel) {
		super();
		this.name = name;
		this.gender = gender;
		this.basicSalary = basicSalary;
		this.dateOfJoin = dateOfJoin;
		this.departmentName = departmentName;
		this.readyToTravel = readyToTravel;
	}
	public Employee(String id) {
		super();
		this.id = id;
	}
	public Employee() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
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
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "\n Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", basicSalary=" + basicSalary
				+ ", dateOfJoin=" + dateOfJoin + ", departmentName=" + departmentName + ", readyToTravel="
				+ readyToTravel + "]";
	}
	
	

}
