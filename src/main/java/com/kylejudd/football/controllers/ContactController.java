package com.kylejudd.football.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kylejudd.football.mail.Contact;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@GetMapping("/contactForm")
	public String contactForm(Model model) {
		
		Contact contact = new Contact();
		
		model.addAttribute("contact", contact);
		
		return "contact-form";
	}
	
	@PostMapping("/sendEmail")
	public String sendEmail(@ModelAttribute("contact") Contact contact) {
		return "";
	}
}
