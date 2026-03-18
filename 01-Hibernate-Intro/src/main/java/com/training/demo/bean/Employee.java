package com.training.demo.bean;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	
	private int empId;
	private String empName;
	private double basicSalary;
	private char grade;
	private LocalDate dateOfBirth,dateOfJoin;
	private boolean manager;
	private Gender gender;
	
	
	
	
	public Employee(int empId, String empName, double basicSalary, char grade, LocalDate dateOfBirth,
			LocalDate dateOfJoin, boolean manager, Gender gender) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.basicSalary = basicSalary;
		this.grade = grade;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoin = dateOfJoin;
		this.manager = manager;
		this.gender=gender;
	}
	
	
	public Employee(String empName, double basicSalary, char grade, LocalDate dateOfBirth, LocalDate dateOfJoin,
			boolean manager, Gender gender) {
		super();
		this.empName = empName;
		this.basicSalary = basicSalary;
		this.grade = grade;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoin = dateOfJoin;
		this.manager = manager;
		this.gender=gender;
	}


	public Employee(int empId) {
		super();
		this.empId = empId;
	}


	public Employee() {
		super();
	}


	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean isManager) {
		this.manager = isManager;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "\nEmployee [empId=" + empId + ", empName=" + empName + ", basicSalary=" + basicSalary + ", grade=" + grade
				+ ", dateOfBirth=" + dateOfBirth + ", dateOfJoin=" + dateOfJoin + ", manager=" + manager + ", gender="
				+ gender + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(empId);
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
		return empId == other.empId;
	}
	

}
