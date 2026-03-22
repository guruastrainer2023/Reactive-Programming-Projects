package com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.bean.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	AppUser findByUserName(String userName);
}
