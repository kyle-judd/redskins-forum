package com.kylejudd.football.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {
	
	@Value("${cloudinary.cloud_name}")
	private String cloudName;
	
	@Value("${cloudinary.api_key}")
	private String apiKey;
	
	@Value("${cloudinary.api_secret}")
	private String apiSecret;
	
	@Bean
	public Cloudinary cloudinary() {
		
		Cloudinary cloudinary = null;
		
		Map<String, String> properties = new HashMap<>();
		
		properties.put("cloud_name", cloudName);
		properties.put("api_key", apiKey);
		properties.put("api_secret", apiSecret);
		
		cloudinary = new Cloudinary(properties);
		
		return cloudinary;
	}
	
}
