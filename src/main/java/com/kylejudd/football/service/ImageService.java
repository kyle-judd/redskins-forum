package com.kylejudd.football.service;

import org.springframework.web.multipart.MultipartFile;

import com.kylejudd.football.entity.PostImage;
import com.kylejudd.football.entity.ProfilePicture;

public interface ImageService {
	
	void saveImage(MultipartFile image) throws Exception;
	
	void saveProfilePicture(MultipartFile image) throws Exception;
	
	PostImage getImageByFileName(String filename);
	
	ProfilePicture getProfilePictureByFileName(String filename);
}
