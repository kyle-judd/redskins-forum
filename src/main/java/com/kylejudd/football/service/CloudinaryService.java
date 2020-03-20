package com.kylejudd.football.service;

import com.kylejudd.football.entity.PostImage;

public interface CloudinaryService {
	
	void saveToDatabase(PostImage postImage);
	PostImage getImageByFileName(String filename);
}
