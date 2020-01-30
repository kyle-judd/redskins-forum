package com.kylejudd.football.dao;

import java.util.List;

import com.kylejudd.football.entity.Post;

public interface PostDao {
	
	Post findPostById(int id);
	
	List<Post> findAllPostsByUserId(int userId);
	
	List<Post> findAllPostsOrderedByNewest();
		
	List<Post> findAllPosts();
	
	void savePost(Post post);
	
	void deletePost(int postId);
}
