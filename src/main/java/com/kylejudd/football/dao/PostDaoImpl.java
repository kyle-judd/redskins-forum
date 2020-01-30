package com.kylejudd.football.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kylejudd.football.entity.Post;
import com.kylejudd.football.entity.User;

@Repository
public class PostDaoImpl implements PostDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Post> findAllPosts() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Post> query = session.createQuery("from Post", Post.class);
		
		List<Post> posts = query.getResultList();
		
		return posts;
	}
	
	@Override
	public Post findPostById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Post post = session.get(Post.class, id);
		
		return post;

	}

	@Override
	public void savePost(Post post) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.save(post);

	}

	@Override
	public void deletePost(int postId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("delete from Post where id=:postId");
		
		query.setParameter("postId", postId);
		
		query.executeUpdate();
	}

	@Override
	public List<Post> findAllPostsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findAllPostsOrderedByNewest() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Post> query = session.createQuery("from Post order by date desc", Post.class);
		
		List<Post> postsOrderedByDate = query.getResultList();
		
		return postsOrderedByDate;
	}

}
