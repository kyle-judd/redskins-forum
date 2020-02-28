package com.kylejudd.football.mail;

public class Contact {
	
	private String name;
	private String email;
	private String subject;
	private String content;
	
	public Contact() {
		
	}
	
	public Contact(String name, String email, String subject, String content) {
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Contact [fromAddress=" + email + ", subject=" + subject + ", content=" + content + "]";
	}
	
}
