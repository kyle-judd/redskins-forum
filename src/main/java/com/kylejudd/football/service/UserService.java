package com.kylejudd.football.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kylejudd.football.entity.User;
import com.kylejudd.football.user.CustomUser;

public interface UserService extends UserDetailsService{
	
	User findByUserName(String username);
	void updateUserProfile(CustomUser user, User currentUser);
	void save(CustomUser user);
}
