package com.kylejudd.football.dao;

import com.kylejudd.football.entity.PostImage;
import com.kylejudd.football.entity.ProfilePicture;

public interface CloudinaryDao {
	
	void savePostImageToDatabase(PostImage postImage);
	void saveProfilePictureToDatabase(ProfilePicture profilePicture);
	ProfilePicture getProfilePictureByFileName(String filename);
	PostImage getPostImageByFileName(String filename);
}
