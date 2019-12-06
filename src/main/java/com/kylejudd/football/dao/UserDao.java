package com.kylejudd.football.dao;

import com.kylejudd.football.entity.User;

public interface UserDao {
	
	User findByUserName(String userName);
	
	void save(User user);
}
