package com.kylejudd.football.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.kylejudd.football.entity.PostImage;
import com.kylejudd.football.entity.ProfilePicture;

@Repository
public class ImageDaoImpl implements ImageDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void saveImage(MultipartFile image) throws Exception {
		
		Session session = entityManager.unwrap(Session.class);
		
		String folder = "/Users/kylejudd/Pictures/app/";
	
		try {
			byte[] bytes = image.getBytes();
			
			Path path = Paths.get(folder + image.getOriginalFilename());
			
			Files.write(path, bytes);
			
			PostImage postImage = new PostImage(path.toString(), image.getOriginalFilename());
			
			session.save(postImage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void saveProfilePicture(MultipartFile image) throws Exception {
		
		Session session = entityManager.unwrap(Session.class);
		
		String folder = "/Users/kylejudd/Pictures/profilePictures/";
		
		try {
			byte[] bytes = image.getBytes();
			
			Path path = Paths.get(folder + image.getOriginalFilename());
			
			Files.write(path, bytes);
			
			ProfilePicture profilePicture = new ProfilePicture(path.toString(), image.getOriginalFilename());
			
			session.save(profilePicture);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public PostImage getImageByFileName(String filename) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<PostImage> query = session.createQuery("from PostImage where filename=:filename", PostImage.class);
		
		query.setParameter("filename", filename);
		
		PostImage postImage = null;
		
		try {
			postImage = query.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
			postImage = null;
		}
		
		return postImage;
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
			profilePicture = null;
		}
		
		return profilePicture;
	}
	
}
