package com.kylejudd.football.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kylejudd.football.dao.ImageDao;
import com.kylejudd.football.entity.PostImage;
import com.kylejudd.football.entity.ProfilePicture;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imageDao;
	
	@Override
	@Transactional
	public void saveImage(MultipartFile image) throws Exception {
		imageDao.saveImage(image);
	}

	@Override
	@Transactional
	public PostImage getImageByFileName(String filename) {
		return imageDao.getImageByFileName(filename);
	}

	@Override
	@Transactional
	public void saveProfilePicture(MultipartFile image) throws Exception {
		imageDao.saveProfilePicture(image);
	}

	@Override
	@Transactional
	public ProfilePicture getProfilePictureByFileName(String filename) {
		return imageDao.getProfilePictureByFileName(filename);
	}

}
