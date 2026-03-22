package com.training.demo.hr.rs.appusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.demo.hr.bean.AppUser;
import com.training.demo.hr.rs.request.appusers.AppUserAddRequest;
import com.training.demo.hr.rs.request.appusers.AppUserAuthenticateRequest;
import com.training.demo.hr.rs.response.appusers.AppUserAddResponse;
import com.training.demo.hr.rs.response.appusers.AppUserAuthenticateResponse;
import com.training.demo.hr.service.appuser.AppUserService;
import com.training.demo.hr.service.appuser.AppUserServiceImpl;
import com.training.demo.hr.service.jwt.JwtUtil;

@RestController
@RequestMapping("/appusers")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})

public class AppUserRESTServiceImpl implements AppUserRESTService{
	
	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	/*@Autowired
	private AuthenticationProvider authenticationProvider;*/
	
	
	@Autowired
	private AppUserServiceImpl appUserServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@PostMapping("/add")
	public ResponseEntity<AppUserAddResponse> addAppUser(@RequestBody AppUserAddRequest appUserAddRequest) throws Exception {
		System.out.println("Add App User REST API");
		AppUserAddResponse appUserAddResponse=new AppUserAddResponse();
		//String pwd=appUserAddRequest.getAppUser().getPassword();
		//appUserAddRequest.getAppUser().setPassword(passwordEncoder.encode(pwd));
		AppUser resultAppUser=this.appUserService.addAppUser(appUserAddRequest.getAppUser());
		appUserAddResponse.setStatusCode(200);
		appUserAddResponse.setMessage("App User Added Successfully");
		appUserAddResponse.setAppUser(resultAppUser);
		return ResponseEntity.ok(appUserAddResponse);
	}

	@Override
	@PostMapping("/login")
	public ResponseEntity<AppUserAuthenticateResponse> authenticate(@RequestBody
			AppUserAuthenticateRequest appUserAurhenticateRequest) throws Exception {
		AppUserAuthenticateResponse appUserAuthenticateResponse=new AppUserAuthenticateResponse();
		
		String userName=appUserAurhenticateRequest.getAppUser().getUserName();
		String password=appUserAurhenticateRequest.getAppUser().getPassword();
		//String pwd=passwordEncoder.encode(password);
		try {
	
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		}catch(BadCredentialsException e) {
			
			appUserAuthenticateResponse.setStatusCode(403);
			appUserAuthenticateResponse.setAppUser(appUserAurhenticateRequest.getAppUser());
			appUserAuthenticateResponse.setMessage("Login Failed");
			e.printStackTrace();
			//throw new Exception("Incorrect UserName or password", e);
			return ResponseEntity.ok(appUserAuthenticateResponse);
		}
		
		UserDetails userDetails=this.appUserServiceImpl.loadUserByUsername(userName);
		String jwt=this.jwtUtil.generateToken(userName);
		
		appUserAuthenticateResponse.setJwt(jwt);
		appUserAuthenticateResponse.setStatusCode(200);
		appUserAuthenticateResponse.setAppUser(appUserAurhenticateRequest.getAppUser());
		appUserAuthenticateResponse.setMessage("Login Successfull");
		
		
		return ResponseEntity.ok(appUserAuthenticateResponse);
	}

}
