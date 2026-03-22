package com.training.demo.hr.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.demo.hr.bean.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
	
	AppUser findByUserName(String userName);

}
