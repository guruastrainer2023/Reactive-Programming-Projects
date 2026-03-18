package com.training.bean.pack5;

import java.time.LocalDate;

public class Person {
	int personId;
	String personName;
	LocalDate dateOfBirth;
	char gender;
	ContactInfo contactInfo;
	
	
	public Person() {
		super();
	}
	public Person(String personName, LocalDate dateOFBirth, char gender, ContactInfo contactInfo) {
		super();
		this.personName = personName;
		this.dateOfBirth = dateOFBirth;
		this.gender = gender;
		this.contactInfo = contactInfo;
	}
	
	
	public Person(int personId, String personName, LocalDate dateOfBirth, char gender, ContactInfo contactInfo) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.contactInfo = contactInfo;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOFBirth) {
		this.dateOfBirth = dateOFBirth;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", dateOFBirth=" + dateOfBirth
				+ ", gender=" + gender + ", contactInfo=" + contactInfo + "]";
	}
	
	
}
