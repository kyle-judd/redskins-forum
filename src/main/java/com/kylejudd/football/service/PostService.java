package com.kylejudd.football.service;

import java.util.List;

import com.kylejudd.football.entity.Post;
import com.kylejudd.football.entity.User;

public interface PostService {
	
	Post findPostById(int id);
		
	List<Post> findAllPosts();
	
	List<Post> findAllPostsOrderedByTime();
	
	List<Post> findAllPostsByUser(User currentUser);
	
	void savePost(Post post);
	
	void deletePost(int postId);
}
