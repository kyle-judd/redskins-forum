package com.kylejudd.football.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kylejudd.football.entity.Post;
import com.kylejudd.football.service.PostService;

@Controller 
public class DemoController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/")
	public String home() {
		return "landing-page";
	}
	
	@GetMapping("/home")
	public String showHome(Model theModel) {
		
		List<Post> posts = postService.findAllPostsOrderedByTime();
		
		theModel.addAttribute("allPosts", posts);
		
		return "home";
	}
	
	@GetMapping("/admin")
	public String adminPage() {
		return "admin";
	}
}
