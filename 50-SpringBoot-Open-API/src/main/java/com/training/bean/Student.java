package com.training.bean;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students50")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int rollNumber;
	
	@Column
	String name;
	
	@Column
	int marks;

	public Student(int rollNumber, String name, int marks) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.marks = marks;
	}

	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	
	

	public Student() {
		super();
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
	
	
}
