package com.training.demo.hr.bean;

import java.util.Objects;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="Departments")

public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String departmentName;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Employee> employees;
	
	private void initEmployees() {
		if(this.employees==null)
			this.employees=new LinkedList<>();
				
	}
	
	
	
	public Department() {
		super();
		initEmployees();
	}



	public Department(int id) {
		super();
		this.id = id;
		initEmployees();
	}
	
	

	public Department(int id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		initEmployees();
	}

	public Department(String departmentName, List<Employee> employees) {
		super();
		this.departmentName = departmentName;
		this.employees = employees;
	}

	public Department(int id, String departmentName, List<Employee> employees) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		
		
			this.employees=employees;
		
	
	}

	@Override
	public String toString() {
		return "\n\n\t Department [id=" + id + ", departmentName=" + departmentName + ", employees=" + employees + "]";
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
		Department other = (Department) obj;
		return id == other.id;
	}
	
	

}
