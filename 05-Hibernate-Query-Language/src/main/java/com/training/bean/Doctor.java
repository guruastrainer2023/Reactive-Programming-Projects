package com.training.bean;

import java.time.LocalDate;
import java.util.Date;

public class Doctor {
	int id;
	String name;
	double fees;
	String gender;
	LocalDate practicingSince;
	
	public Doctor(int id, String name, double fees, String gender, LocalDate practicingSince) {
		super();
		this.id = id;
		this.name = name;
		this.fees = fees;
		this.gender = gender;
		this.practicingSince = practicingSince;
	}
	
	

	public Doctor(String name, double fees, String gender, LocalDate practicingSince) {
		super();
		this.name = name;
		this.fees = fees;
		this.gender = gender;
		this.practicingSince = practicingSince;
	}



	public Doctor() {
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

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getPracticingSince() {
		return practicingSince;
	}

	public void setPracticingSince(LocalDate practicingSince) {
		this.practicingSince = practicingSince;
	}

	@Override
	public String toString() {
		return "\n Doctor [id=" + id + ", name=" + name + ", fees=" + fees + ", gender=" + gender + ", practicingSince="
				+ practicingSince + "]";
	}
	
	
	
}
