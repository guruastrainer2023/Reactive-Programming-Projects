package com.training.bean.pack7;

import java.util.Map;
import java.util.Objects;

public class CustomerStatus {
	private int id;
	private String regionName;
	private Map<String, Customer> statusMap;
	
	public CustomerStatus(int id, String regionName, Map<String, Customer> statusMap) {
		super();
		this.id = id;
		this.regionName = regionName;
		this.statusMap = statusMap;
	}

	public CustomerStatus(String regionName, Map<String, Customer> statusMap) {
		super();
		this.regionName = regionName;
		this.statusMap = statusMap;
	}

	public CustomerStatus(int id) {
		super();
		this.id = id;
	}

	public CustomerStatus() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Map<String, Customer> getStatusMap() {
		return statusMap;
	}

	public void setStatusMap(Map<String, Customer> statusMap) {
		this.statusMap = statusMap;
	}

	@Override
	public String toString() {
		return "\nCustomerStatus [id=" + id + ", regionName=" + regionName + ", statusMap=" + statusMap + "]";
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
		CustomerStatus other = (CustomerStatus) obj;
		return id == other.id;
	}
	
	
	
}
