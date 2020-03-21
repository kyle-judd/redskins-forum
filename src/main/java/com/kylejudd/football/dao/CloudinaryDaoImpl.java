package com.kylejudd.football.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kylejudd.football.entity.PostImage;
import com.kylejudd.football.entity.ProfilePicture;

@Repository
public class CloudinaryDaoImpl implements CloudinaryDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void savePostImageToDatabase(PostImage postImage) {

		Session session = entityManager.unwrap(Session.class);
		
		session.save(postImage);
	}

	@Override
	public PostImage getPostImageByFileName(String filename) {
		
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

	@Override
	public void saveProfilePictureToDatabase(ProfilePicture profilePicture) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.save(profilePicture);
		
	}

	@Override
	public ProfilePicture getProfilePictureByFileName(String filename) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<ProfilePicture> query = session.createQuery("from ProfilePicture where filename=:filename", ProfilePicture.class);
		query.setParameter("filename", filename);
		
		ProfilePicture profilePicture = null;
		
		try {
			profilePicture = query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return profilePicture;
	}

}
