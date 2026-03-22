package com.training.demo.hr.bean;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="Employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private Gender gender;
	
	@Column
	private double basicSalary;
	
	@Column
	private LocalDate dateOfJoin;
	
	@Column
	private boolean readyToTravel;
	
	@ManyToOne
    @JoinColumn(name = "departmentIdfk")
	@JsonBackReference
	private Department department;
	
	private void initDepartment() {
		if(this.department==null)
			this.department=new Department();
		
	}
	
	
	
	public Employee() {
		super();
		initDepartment();
	}



	public Employee(int id) {
		super();
		this.id = id;
		initDepartment();
		
	}
	public Employee(String name, Gender gender, double basicSalary, LocalDate dateOfJoin, boolean readyToTravel,
			Department department) {
		super();
		this.name = name;
		this.gender = gender;
		this.basicSalary = basicSalary;
		this.dateOfJoin = dateOfJoin;
		this.readyToTravel = readyToTravel;
		this.department = department;
	}
	public Employee(int id, String name, Gender gender, double basicSalary, LocalDate dateOfJoin, boolean readyToTravel,
			Department department) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.basicSalary = basicSalary;
		this.dateOfJoin = dateOfJoin;
		this.readyToTravel = readyToTravel;
		this.department = department;
	}
	public Employee(int id, String name, Gender gender, double basicSalary, LocalDate dateOfJoin,
			boolean readyToTravel) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.basicSalary = basicSalary;
		this.dateOfJoin = dateOfJoin;
		this.readyToTravel = readyToTravel;
		initDepartment();
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
	public boolean isReadyToTravel() {
		return readyToTravel;
	}
	public void setReadyToTravel(boolean readyToTravel) {
		this.readyToTravel = readyToTravel;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", basicSalary=" + basicSalary
				+ ", dateOfJoin=" + dateOfJoin + ", readyToTravel=" + readyToTravel + "]";
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
