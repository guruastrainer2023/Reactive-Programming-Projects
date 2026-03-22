package com.training.demo.hr.rs.appusers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.demo.hr.rs.request.appusers.AppUserAddRequest;
import com.training.demo.hr.rs.request.appusers.AppUserAuthenticateRequest;
import com.training.demo.hr.rs.response.appusers.AppUserAddResponse;
import com.training.demo.hr.rs.response.appusers.AppUserAuthenticateResponse;




public interface AppUserRESTService {
	
	ResponseEntity<AppUserAddResponse> addAppUser(AppUserAddRequest appUserAddRequest) throws Exception;
	ResponseEntity<AppUserAuthenticateResponse> authenticate(AppUserAuthenticateRequest appUserAurhenticateRequest) throws Exception;
	
}
