package com.kylejudd.football.dao;

import org.springframework.web.multipart.MultipartFile;

import com.kylejudd.football.entity.PostImage;
import com.kylejudd.football.entity.ProfilePicture;

public interface ImageDao {
	
	void saveImage(MultipartFile image) throws Exception;
	
	void saveProfilePicture(MultipartFile image) throws Exception;
	
	PostImage getImageByFileName(String filename);
	
	ProfilePicture getProfilePictureByFileName(String filename);
}
