package com.training.bean.pack4;

public class ContactInfo {
	int contactId;
	String email;
	String phone;
	
	
	
	public ContactInfo() {
		super();
	}
	public ContactInfo(String email, String phone) {
		super();
		this.email = email;
		this.phone = phone;
	
	}
	
	public ContactInfo(int contactId, String email, String phone ) {
		super();
		this.contactId = contactId;
		this.email = email;
		this.phone = phone;
		
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
	@Override
	public String toString() {
		return "ContactInfo [contactId=" + contactId + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
	
	
}
