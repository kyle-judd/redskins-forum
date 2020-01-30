package com.kylejudd.football.service;

import java.util.List;

import com.kylejudd.football.entity.Post;

public interface PostService {
	
	Post findPostById(int id);
		
	List<Post> findAllPosts();
	
	List<Post> findAllPostsOrderedByTime();
	
	void savePost(Post post);
	
	void deletePost(int postId);
}
