package com.kylejudd.football.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kylejudd.football.entity.Post;
import com.kylejudd.football.entity.User;
import com.kylejudd.football.service.PostService;
import com.kylejudd.football.service.UserService;

@Controller 
public class HomeController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "landing-page";
	}
	
	@GetMapping("/home")
	public String showHome(Model theModel) {
		
		List<Post> posts = postService.findAllPostsOrderedByTime();
		
		theModel.addAttribute("allPosts", posts);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails currentUserDetails = userService.loadUserByUsername(auth.getName());
		
		String currentUsername = currentUserDetails.getUsername();
				
		User currentUser = userService.findByUserName(currentUsername);
		
		theModel.addAttribute("currentUser", currentUser);
		
		return "home";
	}
	
	@GetMapping("/about")
	public String aboutPage() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/admin")
	public String adminPage() {
		return "admin";
	}
}
