package com.kylejudd.football.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kylejudd.football.entity.PostImage;
import com.kylejudd.football.entity.ProfilePicture;

public interface CloudinaryService {
	
	void savePostImageToDatabase(PostImage postImage);
	void saveProfilePictureToDatabase(ProfilePicture profilePicture);
	ProfilePicture getProfilePictureByFileName(String filename);
	PostImage getPostImageByFileName(String filename);
	Map uploadPostImage(MultipartFile uploadedImage);
	Map uploadProfilePicture(MultipartFile uploadedImage);
}
