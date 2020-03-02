package com.kylejudd.football.service;

public interface MailService {
	
	void sendEmail(String fromAddress, String toAddress, String subject, String content) throws Exception;
}
