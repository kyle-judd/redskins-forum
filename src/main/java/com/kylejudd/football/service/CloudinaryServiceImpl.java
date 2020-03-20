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

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
	
	@Autowired
	private Cloudinary cloudinary;
	
	@Autowired
	private CloudinaryDao cloudinaryDao;
	
	@SuppressWarnings("rawtypes")
	public Map uploadPostImage(MultipartFile multipartFile) {
		
		try {
			File uploadedFile = convertMultipartToFile(multipartFile);
			Map params = ObjectUtils.asMap("pubic_id", "post_images/");
			Map uploadResult = cloudinary.uploader().upload(uploadedFile, params);
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
	public void saveToDatabase(PostImage postImage) {
		cloudinaryDao.saveToDatabase(postImage);
	}

	@Override
	@Transactional
	public PostImage getImageByFileName(String filename) {
		return cloudinaryDao.getImageByFileName(filename);
	}
}
