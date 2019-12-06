package com.kylejudd.football.controllers;

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

import com.kylejudd.football.entity.User;
import com.kylejudd.football.service.UserService;
import com.kylejudd.football.user.CustomUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private UserService userService;
	
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
	public String processRegistrationForm(
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
			logger.warn("Username already exists");
		}
		
		userService.save(user);
		
		logger.info("Successfully created user: " + username);
		
		return "registration-success";
	}
}
