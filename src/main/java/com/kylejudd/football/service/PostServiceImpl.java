package com.kylejudd.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kylejudd.football.dao.PostDao;
import com.kylejudd.football.entity.Post;
import com.kylejudd.football.entity.User;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDao postDao;
	
	@Override
	@Transactional
	public Post findPostById(int id) {
		return postDao.findPostById(id);
	}

	@Override
	@Transactional
	public List<Post> findAllPosts() {
		return postDao.findAllPosts();
	}

	@Override
	@Transactional
	public void savePost(Post post) {
		postDao.savePost(post);
	}

	@Override
	@Transactional
	public void deletePost(int postId) {
		postDao.deletePost(postId);
	}

	@Override
	@Transactional
	public List<Post> findAllPostsOrderedByTime() {
		return postDao.findAllPostsOrderedByNewest();
	}

	@Override
	@Transactional
	public List<Post> findAllPostsByUser(User currentUser) {
		return postDao.findAllPostsByUser(currentUser);
	}

}
