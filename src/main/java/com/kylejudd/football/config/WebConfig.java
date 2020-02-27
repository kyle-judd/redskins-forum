package com.kylejudd.football.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/posts/images/**").addResourceLocations("file:/Users/kylejudd/Pictures/app/");
		
		registry.addResourceHandler("/profile/picture/**").addResourceLocations("file:/Users/kylejudd/Pictures/profilePictures/")
														  .addResourceLocations("file:/Users/kylejudd/Pictures/profilePictures/default/");
	}

	
}
