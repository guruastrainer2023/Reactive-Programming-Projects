package com.training.bean.pack3;

import java.util.Set;
import java.util.TreeSet;

public class State {
	private int id;
	private String name;
	private Set<String> cityNames;
	
	public State(String name) {
		super();
		this.name = name;
		this.cityNames=new TreeSet<>();
	}

	public State() {
		super();
		this.cityNames=new TreeSet<>();
	}
	
	
	
	public State(int id) {
		super();
		this.id = id;
	}

	public void addCityName(String cityName){
		this.cityNames.add(cityName);
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

	public Set<String> getCityNames() {
		return cityNames;
	}

	public void setCityNames(Set<String> cityNames) {
		this.cityNames = cityNames;
	}

	@Override
	public String toString() {
		return "\n State [id=" + id + ", name=" + name + ", cityNames=" + cityNames + "]";
	}
	
	
	
	
	

}
