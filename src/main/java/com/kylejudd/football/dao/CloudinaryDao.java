package com.kylejudd.football.dao;

import com.kylejudd.football.entity.PostImage;

public interface CloudinaryDao {
	
	void saveToDatabase(PostImage postImage);
	
	PostImage getImageByFileName(String filename);
}
