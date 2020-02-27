package com.kylejudd.football.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "profilepicture")
public class ProfilePicture {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "filename")
	private String filename;
	
	@OneToOne(mappedBy = "profilePicture")
	private User user;
	
	public ProfilePicture() {
		
	}
	
	public ProfilePicture(String path, String filename) {
		this.path = path;
		this.filename = filename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ProfilePicture [id=" + id + ", path=" + path + ", filename=" + filename + ", user=" + user + "]";
	}

}
