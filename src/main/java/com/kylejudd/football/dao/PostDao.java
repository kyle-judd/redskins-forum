package com.kylejudd.football.dao;

import java.util.List;

import com.kylejudd.football.entity.Post;
import com.kylejudd.football.entity.User;

public interface PostDao {
	
	Post findPostById(int id);
	
	List<Post> findAllPostsByUser(User currentUser);
	
	List<Post> findAllPostsOrderedByNewest();
		
	List<Post> findAllPosts();
	
	void savePost(Post post);
	
	void deletePost(int postId);
}
