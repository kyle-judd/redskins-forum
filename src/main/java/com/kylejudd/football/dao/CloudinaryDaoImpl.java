package com.kylejudd.football.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kylejudd.football.entity.PostImage;

@Repository
public class CloudinaryDaoImpl implements CloudinaryDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void saveToDatabase(PostImage postImage) {

		Session session = entityManager.unwrap(Session.class);
		
		session.save(postImage);
	}

	@Override
	public PostImage getImageByFileName(String filename) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<PostImage> query = session.createQuery("from PostImage where filename=:filename", PostImage.class);
		query.setParameter("filename", filename);
		
		PostImage postImage = null;
		
		try {
			postImage = query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return postImage;
	}

}
