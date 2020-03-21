package com.kylejudd.football.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kylejudd.football.entity.ProfilePicture;
import com.kylejudd.football.entity.User;
import com.kylejudd.football.service.CloudinaryServiceImpl;
import com.kylejudd.football.service.UserService;
import com.kylejudd.football.user.CustomUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CloudinaryServiceImpl cloudinaryService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/registrationForm")
	public String showRegistrationForm(Model model) {
		
		model.addAttribute("customUser", new CustomUser());
		
		return "registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@RequestParam("image") MultipartFile image,
										  @Valid @ModelAttribute("customUser") CustomUser user, 
										  BindingResult bindingResult,
										  Model model) {
		
		String username = user.getUsername();
		
		logger.info("Processing registration for username: " + username);
		
		if(bindingResult.hasErrors()) {
			return "registration-form";
		}
		
		User existing = userService.findByUserName(username);
		
		if(existing != null) {
			model.addAttribute("customUser", new CustomUser());
			model.addAttribute("registrationError", "Username already exists");
			logger.warn("Username: " + username + " already exists!");
			return "registration-form";
		}
		
		if(image == null) {
			user.setProfilePicture(cloudinaryService.getProfilePictureByFileName("71ed4d29fbad769786476d37b35c5441.jpg"));
		} else {
			Map uploadedProfilePicture = cloudinaryService.uploadPostImage(image);
			
			String path = (String) uploadedProfilePicture.get("url");
			
			String publicId = (String) uploadedProfilePicture.get("public_id");
			
			String format = (String) uploadedProfilePicture.get("format");
			
			String fileName = publicId + format;
			
			ProfilePicture profilePicture = new ProfilePicture(path, fileName);
			
			cloudinaryService.saveProfilePictureToDatabase(profilePicture);
			
			ProfilePicture profilePictureFromDatabase = cloudinaryService.getProfilePictureByFileName(fileName);
			
			user.setProfilePicture(profilePictureFromDatabase);
			
		}
		
		userService.save(user);
		
		logger.info("Successfully created user: " + username);
		
		return "registration-success";
	}
}
