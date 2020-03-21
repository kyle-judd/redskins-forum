package com.kylejudd.football.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kylejudd.football.dao.CloudinaryDao;
import com.kylejudd.football.entity.PostImage;
import com.kylejudd.football.entity.ProfilePicture;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
	
	@Autowired
	private Cloudinary cloudinary;
	
	@Autowired
	private CloudinaryDao cloudinaryDao;
	
	@Override
	public Map uploadPostImage(MultipartFile postImage) {
		
		try {
			File uploadedFile = convertMultipartToFile(postImage);
			Map uploadResult = cloudinary.uploader().upload(uploadedFile, ObjectUtils.emptyMap());
			return uploadResult;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {
		
		File convertedFile = new File(multipartFile.getOriginalFilename());
		
		FileOutputStream fileOutputStream = new FileOutputStream(convertedFile);
		
		fileOutputStream.write(multipartFile.getBytes());
		
		fileOutputStream.close();
		
		return convertedFile;
	}

	@Override
	@Transactional
	public void savePostImageToDatabase(PostImage postImage) {
		cloudinaryDao.savePostImageToDatabase(postImage);
	}

	@Override
	@Transactional
	public PostImage getPostImageByFileName(String filename) {
		return cloudinaryDao.getPostImageByFileName(filename);
	}

	@Override
	@Transactional
	public void saveProfilePictureToDatabase(ProfilePicture profilePicture) {
		cloudinaryDao.saveProfilePictureToDatabase(profilePicture);
	}

	@Override
	@Transactional
	public ProfilePicture getProfilePictureByFileName(String filename) {
		return cloudinaryDao.getProfilePictureByFileName(filename);
	}

	@Override
	public Map uploadProfilePicture(MultipartFile uploadedImage) {
		
		try {
			File uploadedFile = convertMultipartToFile(uploadedImage);
			Map uploadResult = cloudinary.uploader().upload(uploadedFile, ObjectUtils.emptyMap());
			return uploadResult;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
