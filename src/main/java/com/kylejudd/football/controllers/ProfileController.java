package com.kylejudd.football.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kylejudd.football.entity.Post;
import com.kylejudd.football.entity.PostImage;
import com.kylejudd.football.entity.ProfilePicture;
import com.kylejudd.football.entity.User;
import com.kylejudd.football.service.CloudinaryService;
import com.kylejudd.football.service.PostService;
import com.kylejudd.football.service.UserService;
import com.kylejudd.football.user.CustomUser;

@Controller
public class ProfileController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CloudinaryService cloudinaryService;
	
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
	
	@PostMapping("/editProfilePicture")
	public String editProfilePicture(@RequestParam("profile-image") MultipartFile profileImage) {
		
		Map upload = cloudinaryService.uploadPostImage(profileImage);
		
		String path = (String) upload.get("url");
		
		String publicId = (String) upload.get("public_id");
		
		String format = (String) upload.get("format");
		
		String fileName = publicId + format;
		
		ProfilePicture profilePicture = new ProfilePicture(path, fileName);
		
		cloudinaryService.saveProfilePictureToDatabase(profilePicture);
		
		ProfilePicture newProfilePicture = cloudinaryService.getProfilePictureByFileName(fileName);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails currentUserDetails = userService.loadUserByUsername(auth.getName());
		
		String currentUserName = currentUserDetails.getUsername();
		
		User currentUser = userService.findByUserName(currentUserName);
		
		currentUser.setProfilePicture(newProfilePicture);
		
		userService.saveOrUpdateUser(currentUser);
		
		return "redirect:/myProfile";
		
	}

}