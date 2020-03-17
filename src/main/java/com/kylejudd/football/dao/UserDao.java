package com.kylejudd.football.dao;

import com.kylejudd.football.entity.User;

public interface UserDao {
	
	User findByUserName(String username);
	User findUserById(int id);
	void updateUserProfile(User user);
	void save(User user);
}
