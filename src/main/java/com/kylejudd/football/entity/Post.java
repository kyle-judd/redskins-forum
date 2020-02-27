package com.kylejudd.football.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne
    @JoinColumn(name = "user")
    private User user;
	
	@Column(name = "date")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@OneToOne
	@JoinColumn(name = "file")
	private PostImage postImage;
	
	public Post() {
		
	}
	

	public Post(String content, User user, Date date, PostImage postImage) {
		this.content = content;
		this.user = user;
		this.date = date;
		this.postImage = postImage;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public PostImage getPostImage() {
		return postImage;
	}


	public void setPostImage(PostImage postImage) {
		this.postImage = postImage;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", date=" + date + ", file=" + postImage + "]";
	}
	
}
