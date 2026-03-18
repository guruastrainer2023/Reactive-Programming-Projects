package com.training.bean.pack1;

import java.util.Arrays;
import java.util.Objects;

public class Candidate {
	
	private int id;
	private String name;
	private String city;
	private double[] marks;
	
	public Candidate(int id, String name, String city, double[] marks) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.marks = marks;
	}
	public Candidate() {
		super();
	}
	
	
	public Candidate(int id) {
		super();
		this.id = id;
	}
	public Candidate(String name, String city, double[] marks) {
		super();
		this.name = name;
		this.city = city;
		this.marks = marks;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double[] getMarks() {
		return marks;
	}
	public void setMarks(double[] marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "\nCandidate [id=" + id + ", name=" + name + ", city=" + city + ", marks=" + Arrays.toString(marks) + "]";
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
		Candidate other = (Candidate) obj;
		return id == other.id;
	}
	
	

}
