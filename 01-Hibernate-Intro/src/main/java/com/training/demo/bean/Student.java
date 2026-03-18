package com.training.demo.bean;

import java.util.Objects;

public class Student {
	private int rollNumber;
	private String name;
	private int marks;
	
	private Address address;

	public Student(int rollNumber, String name, int marks, Address address) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.marks = marks;
		this.address = address;
	}

	public Student(String name, int marks, Address address) {
		super();
		this.name = name;
		this.marks = marks;
		this.address = address;
	}

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

	public Student(int rollNumber) {
		super();
		this.rollNumber = rollNumber;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "\nStudent [rollNumber=" + rollNumber + ", name=" + name + ", marks=" + marks + ", address=" + address
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(rollNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return rollNumber == other.rollNumber;
	}
	
	

}
