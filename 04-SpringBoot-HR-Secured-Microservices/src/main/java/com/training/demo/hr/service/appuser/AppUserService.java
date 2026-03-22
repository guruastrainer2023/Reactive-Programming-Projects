package com.training.demo.hr.service.appuser;

import com.training.demo.hr.bean.AppUser;
import com.training.demo.hr.db.AppUserRepository;

public interface AppUserService {
	
	AppUser addAppUser(AppUser appUser);
	
}
