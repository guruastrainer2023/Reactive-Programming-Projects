package com.training.demo.bean;

import java.time.LocalDate;
import java.util.Objects;







public class Employee {
	
	
	private int id;
	
	
	private String name;
	

	private Gender gender;
	
	
	private double basicSalary;
	
	
	private LocalDate dateOfJoin;
	
	
	private boolean readyToTravel;
	
	
	
	
	
	public Employee() {
		super();
		
	}



	public Employee(int id) {
		super();
		this.id = id;
		
	}
	public Employee(String name, Gender gender, double basicSalary, LocalDate dateOfJoin, boolean readyToTravel) {
		super();
		this.name = name;
		this.gender = gender;
		this.basicSalary = basicSalary;
		this.dateOfJoin = dateOfJoin;
		this.readyToTravel = readyToTravel;
		
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
