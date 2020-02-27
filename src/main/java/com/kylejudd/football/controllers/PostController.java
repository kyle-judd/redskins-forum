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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kylejudd.football.entity.Post;
import com.kylejudd.football.entity.PostImage;
import com.kylejudd.football.entity.User;
import com.kylejudd.football.service.ImageService;
import com.kylejudd.football.service.PostService;
import com.kylejudd.football.service.UserService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ImageService imageService;
	
	@GetMapping("/showPost")
	public String showPost(Model theModel) {
		
		Post post = new Post();
		
		theModel.addAttribute("newPost", post);
		
		return "post";
	}
	
	@PostMapping("/savePost")
	public String saveMapping(@RequestParam("imageFile") MultipartFile imageFile, @ModelAttribute("post") Post thePost) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails currentUserDetails = userService.loadUserByUsername(auth.getName());
		
		System.out.println("Current user is: " + currentUserDetails);
		
		String currentUsername = currentUserDetails.getUsername();
				
		User currentUser = userService.findByUserName(currentUsername);
		
		thePost.setUser(currentUser);
		
		try {
			imageService.saveImage(imageFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PostImage postImage = imageService.getImageByFileName(imageFile.getOriginalFilename());
		
		thePost.setPostImage(postImage);
		
		postService.savePost(thePost);
		
		return "redirect:/home";
	}
	
	@GetMapping("/deletePost")
	public String deletePost(@RequestParam("postId") int postId) {
		
		postService.deletePost(postId);
		
		return "redirect:/home";
	}
}
