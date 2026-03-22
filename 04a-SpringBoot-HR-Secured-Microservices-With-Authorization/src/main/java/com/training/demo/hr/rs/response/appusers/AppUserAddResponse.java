package com.training.demo.hr.rs.response.appusers;

import com.training.demo.hr.bean.AppUser;

public class AppUserAddResponse {
	
	private int statusCode;
	private String message;
	private AppUser appUser;
	
	

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
}
