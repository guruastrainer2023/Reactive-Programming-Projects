package com.training.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees100")
public class Employee {
	
	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String gender;
	
	@Column
	private String department;
	
	@Column
	private LocalDate dateOfJoin;
	
	@Column
	private double basicSalary;
	
	@Column
	private boolean relocation;
	
	public Employee(int id, String name, String gender, String department, LocalDate dateOfJoin, double basicSalary,
			boolean relocation) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.dateOfJoin = dateOfJoin;
		this.basicSalary = basicSalary;
		this.relocation = relocation;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public boolean isRelocation() {
		return relocation;
	}

	public void setRelocation(boolean relocation) {
		this.relocation = relocation;
	}

	@Override
	public String toString() {
		return "\n Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department
				+ ", dateOfJoin=" + dateOfJoin + ", basicSalary=" + basicSalary + ", relocation=" + relocation + "]";
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
		return id == other.id;
	}
	
	
	
	
}
