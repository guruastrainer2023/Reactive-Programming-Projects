package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persons1")
public class Person {
	
	@Id
	private String _id;
	private String name;
	private int age;
	public Person(String id, String name, int age) {
		super();
		this._id = id;
		this.name = name;
		this.age = age;
	}
	public Person() {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [id=" + _id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
