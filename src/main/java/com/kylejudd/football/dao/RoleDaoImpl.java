package com.kylejudd.football.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kylejudd.football.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Role findRoleByName(String theRoleName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Role> query = currentSession.createQuery("from Role where type=:roleType", Role.class);
		query.setParameter("roleType", theRoleName);
		
		Role role = null;
		
		try {
			role = query.getSingleResult();
		} catch(Exception e) {
			role = null;
		}
		
		return role;
	}

}
