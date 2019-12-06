package com.kylejudd.football.dao;

import com.kylejudd.football.entity.Role;

public interface RoleDao {
	
	Role findRoleByName(String theRoleName);
}
