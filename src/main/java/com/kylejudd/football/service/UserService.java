package com.kylejudd.football.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kylejudd.football.entity.User;
import com.kylejudd.football.user.CustomUser;

public interface UserService extends UserDetailsService{
	
	User findByUserName(String userName);
	void save(CustomUser user);
}
