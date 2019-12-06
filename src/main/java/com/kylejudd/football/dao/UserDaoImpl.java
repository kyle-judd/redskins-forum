package com.kylejudd.football.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kylejudd.football.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public User findByUserName(String userName) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<User> query = session.createQuery("from User where userName=:uName", User.class);
		query.setParameter("uName", userName);
		
		User user = null;
		
		try {
			user = query.getSingleResult();
		} catch(Exception e) {
			user = null;
		}
		
		return user;
	}

	@Override
	public void save(User user) {
		
		Session session =entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(user);
	}

}
