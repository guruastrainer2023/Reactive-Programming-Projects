package com.training.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.AppUser;
import com.training.request.AppUserAddRequest;
import com.training.request.AppUserAuthenticateRequest;
import com.training.response.AppUserAddResponse;
import com.training.response.AppUserAuthenticateResponse;
import com.training.securityconfig.JwtUtil;
import com.training.service.AppUserService;
import com.training.service.AppUserServiceImpl;

@RestController
@RequestMapping("/appusers")
public class AppUserRESTServiceImpl {

	@Autowired
	private AppUserService appUserService;

	@Autowired
	private AuthenticationManager authenticationManager;

	/*
	 * @Autowired private AuthenticationProvider authenticationProvider;
	 */

	@Autowired
	private AppUserServiceImpl appUserServiceImpl;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@PostMapping("/add")
	public ResponseEntity<AppUserAddResponse> addAppUser(@RequestBody AppUserAddRequest appUserAddRequest)
			throws Exception {
		System.out.println("Add App User REST API");
		AppUserAddResponse appUserAddResponse = new AppUserAddResponse();
		// String pwd=appUserAddRequest.getAppUser().getPassword();
		// appUserAddRequest.getAppUser().setPassword(passwordEncoder.encode(pwd));
		AppUser resultAppUser = this.appUserService.addAppUser(appUserAddRequest.getAppUser());
		appUserAddResponse.setStatusCode(200);
		appUserAddResponse.setMessage("App User Added Successfully");
		appUserAddResponse.setAppUser(resultAppUser);
		System.out.println(resultAppUser);
		return ResponseEntity.ok(appUserAddResponse);
	}


	@PostMapping("/login")
	public ResponseEntity<AppUserAuthenticateResponse> authenticate(
			@RequestBody AppUserAuthenticateRequest appUserAurhenticateRequest) throws Exception {
		AppUserAuthenticateResponse appUserAuthenticateResponse = new AppUserAuthenticateResponse();
		System.out.println("App User REST API login");
		String userName = appUserAurhenticateRequest.getAppUser().getUserName();
		String password = appUserAurhenticateRequest.getAppUser().getPassword();
		System.out.println(userName);
		System.out.println(password);
		// String pwd=passwordEncoder.encode(password);
		try {
			System.out.println("try block");
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		} catch (BadCredentialsException e) {

			appUserAuthenticateResponse.setStatusCode(403);
			appUserAuthenticateResponse.setAppUser(appUserAurhenticateRequest.getAppUser());
			appUserAuthenticateResponse.setMessage("Login Failed");
			e.printStackTrace();
			// throw new Exception("Incorrect UserName or password", e);
			return ResponseEntity.ok(appUserAuthenticateResponse);
		}

		UserDetails userDetails = this.appUserServiceImpl.loadUserByUsername(userName);
		String jwt = this.jwtUtil.generateToken(userName);

		appUserAuthenticateResponse.setJwt(jwt);
		appUserAuthenticateResponse.setStatusCode(200);
		appUserAuthenticateResponse.setAppUser(appUserAurhenticateRequest.getAppUser());
		appUserAuthenticateResponse.setMessage("Login Successfull");

		return ResponseEntity.ok(appUserAuthenticateResponse);
	}
}
