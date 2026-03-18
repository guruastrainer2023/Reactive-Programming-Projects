package com.training.bean.pack3;

public class ContactInfo {
	int contactId;
	String email;
	String phone;
	Person person;
	
	
	public ContactInfo() {
		super();
	}
	public ContactInfo(String email, String phone, Person person) {
		super();
		this.email = email;
		this.phone = phone;
		this.person = person;
	}
	
	public ContactInfo(int contactId, String email, String phone, Person person) {
		super();
		this.contactId = contactId;
		this.email = email;
		this.phone = phone;
		this.person = person;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "ContactInfo [contactId=" + contactId + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
	
}
