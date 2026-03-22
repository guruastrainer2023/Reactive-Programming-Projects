package com.training.ui;

import org.springframework.http.ResponseEntity;

import com.training.request.AppUserAddRequest;
import com.training.request.AppUserAuthenticateRequest;
import com.training.response.AppUserAddResponse;
import com.training.response.AppUserAuthenticateResponse;

public interface AppUserRESTService {
	ResponseEntity<AppUserAddResponse> addAppUser(AppUserAddRequest appUserAddRequest) throws Exception;

	ResponseEntity<AppUserAuthenticateResponse> authenticate(AppUserAuthenticateRequest appUserAurhenticateRequest)
			throws Exception;
}
