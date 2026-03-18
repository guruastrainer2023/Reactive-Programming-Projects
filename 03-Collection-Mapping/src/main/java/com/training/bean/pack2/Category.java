package com.training.bean.pack2;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Category {
	private int id;
	private String categoryName;
	private List<String> technologyNames;
	
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
		this.technologyNames=new LinkedList<>();
	}

	public Category() {
		super();
		this.technologyNames=new LinkedList<>();
	}
	
	
	
	public Category(int id) {
		super();
		this.id = id;
	}

	public void add(String technologyName){
		this.technologyNames.add(technologyName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<String> getTechnologyNames() {
		return technologyNames;
	}

	public void setTechnologyNames(List<String> technologyNames) {
		this.technologyNames = technologyNames;
	}

	@Override
	public String toString() {
		return "\nCategory [id=" + id + ", categoryName=" + categoryName + ", technologyNames=" + technologyNames + "]";
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
		Category other = (Category) obj;
		return id == other.id;
	}
	
	
	
}
