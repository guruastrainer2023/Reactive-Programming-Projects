package com.training.demo.hr.rs.request.appusers;

import com.training.demo.hr.bean.AppUser;

public class AppUserAuthenticateRequest {

	private AppUser appUser;

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
}
