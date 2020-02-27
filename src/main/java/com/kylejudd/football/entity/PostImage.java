package com.kylejudd.football.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pimages")
public class PostImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "filename")
	private String fileName;
	
	@OneToOne(mappedBy = "postImage")
	private Post post;
	
	public PostImage() {
		
	}
	
	public PostImage(String path, String filename) {
		this.path = path;
		this.fileName = filename;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "PostImage [id=" + id + ", path=" + path + ", fileName=" + fileName + "]";
	}
	
}
