package com.training.demo.hr.rs.response.appusers;

import com.training.demo.hr.bean.AppUser;

public class AppUserAuthenticateResponse {

	private String jwt;
	
	private int statusCode;
	private AppUser appUser;
	private String message;
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public AppUserAuthenticateResponse() {
		super();
	}

	public AppUserAuthenticateResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
