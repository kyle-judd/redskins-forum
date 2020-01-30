package com.kylejudd.football.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kylejudd.football.entity.Post;
import com.kylejudd.football.entity.User;
import com.kylejudd.football.service.PostService;
import com.kylejudd.football.service.UserService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/showPost")
	public String showPost(Model theModel) {
		
		Post post = new Post();
		
		theModel.addAttribute("newPost", post);
		
		return "post";
	}
	
	@PostMapping("/savePost")
	public String saveMapping(@ModelAttribute("post") Post thePost) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails currentUserDetails = userService.loadUserByUsername(auth.getName());
		
		System.out.println("Current user is: " + currentUserDetails);
		
		String currentUsername = currentUserDetails.getUsername();
				
		User currentUser = userService.findByUserName(currentUsername);
		
		thePost.setUser(currentUser);
		
		postService.savePost(thePost);
		
		return "redirect:/home";
	}
}
