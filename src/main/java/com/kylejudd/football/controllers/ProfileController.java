package com.kylejudd.football.controllers;

import java.util.List;

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
import com.kylejudd.football.user.CustomUser;

@Controller
public class ProfileController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/myProfile")
	public String displayUserProfile(Model model) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails currentUserDetails = userService.loadUserByUsername(auth.getName());
		
		String currentUserName = currentUserDetails.getUsername();
		
		User currentUser = userService.findByUserName(currentUserName);
		
		List<Post> postsByUser = postService.findAllPostsByUser(currentUser);
		
		model.addAttribute("postsByUser", postsByUser);
		
		model.addAttribute("editUser", new CustomUser());
		
		model.addAttribute("loggedInUser", currentUser);
		
		return "my-profile";
	}
	
	@PostMapping("/editUser")
	public String editUser(@ModelAttribute("editUser") CustomUser customUser, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails currentUserDetails = userService.loadUserByUsername(auth.getName());
		
		String currentUserName = currentUserDetails.getUsername();
		
		User currentUser = userService.findByUserName(currentUserName);
		
		userService.updateUserProfile(customUser, currentUser);
		
		return "profile-edit-success";
	}

}