package com.kylejudd.football.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kylejudd.football.entity.User;
import com.kylejudd.football.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/myProfile")
	public String displayUserProfile(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails currentUserDetails = userService.loadUserByUsername(auth.getName());
		
		String currentUserName = currentUserDetails.getUsername();
		
		User currentUser = userService.findByUserName(currentUserName);
		
		model.addAttribute("loggedInUser", currentUser);
		
		return "my-profile";
	}
}
