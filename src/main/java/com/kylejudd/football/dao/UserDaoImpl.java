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
	public User findByUserName(String username) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<User> query = session.createQuery("from User where username=:uName", User.class);
		query.setParameter("uName", username);
		
		User user = null;
		
		try {
			user = query.getSingleResult();
		}
		catch(Exception e) {
			user = null;
			e.printStackTrace();
		}
		
		return user;

	}

	@Override
	public void save(User user) {
		
		Session session =entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(user);
	}

}
