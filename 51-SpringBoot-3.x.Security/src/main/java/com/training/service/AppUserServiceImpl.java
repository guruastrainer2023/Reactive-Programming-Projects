package com.training.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.bean.AppUser;
import com.training.dao.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

	@Autowired
	private AppUserRepository appUserRespository;
	
	

	public AppUserServiceImpl() {
		super();
		System.out.println("App userService instantiated");
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("This load user function is working");
		System.out.println(username);
		User user;
		AppUser appUser = this.appUserRespository.findByUserName(username);
		user = new User(appUser.getUserName(), appUser.getPassword(), new ArrayList<>());
		System.out.println(appUser.getUserName()+","+appUser.getPassword());
		return user;
	}

	@Override
	public AppUser addAppUser(AppUser appUser) {
		AppUser appUser2 = this.appUserRespository.save(appUser);
		return appUser2;
	}

}
