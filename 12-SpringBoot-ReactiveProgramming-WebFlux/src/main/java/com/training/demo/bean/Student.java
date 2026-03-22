package com.training.demo.bean;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "students")
public class Student {
	
	@Id 
	private String id; 
    private String name; 
    private int age; 
  
    public Student(String id, String name, int age) 
    { 
        super(); 
        this.id = id; 
        this.name = name; 
        this.age = age; 
    } 
  
    public Student() 
    { 
        super(); 
        // TODO Auto-generated constructor stub 
    } 
  
    public String getId() { return id; } 
  
    public void setId(String id) { this.id = id; } 
  
    public String getName() { return name; } 
  
    public void setName(String name) { this.name = name; } 
  
    public int getAge() { return age; } 
  
    public void setAge(int age) { this.age = age; }

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
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
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	} 
    
    


}
