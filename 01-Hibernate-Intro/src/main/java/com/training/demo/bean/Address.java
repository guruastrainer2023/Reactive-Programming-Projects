package com.training.demo.bean;

public class Address {
	
	private String doorNumber;
	private String streetName;
	private String areaName;
	private String city;
	private String pincode;
	public Address(String doorNumber, String streetName, String areaName, String city, String pincode) {
		super();
		this.doorNumber = doorNumber;
		this.streetName = streetName;
		this.areaName = areaName;
		this.city = city;
		this.pincode = pincode;
	}
	public Address() {
		super();
	}
	public String getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Address [doorNumber=" + doorNumber + ", streetName=" + streetName + ", areaName=" + areaName + ", city="
				+ city + ", pincode=" + pincode + "]";
	}
	
	

}
