package com.kylejudd.football.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kylejudd.football.mail.Contact;
import com.kylejudd.football.service.MailService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private MailService mailService;
	
	@Value("${spring.mail.username}")
	private String toEmail;
	
	@GetMapping("/contactForm")
	public String contactForm(Model model) {
		
		Contact contact = new Contact();
		
		model.addAttribute("contact", contact);
		
		return "contact-form";
	}
	
	@PostMapping("/sendEmail")
	public String sendEmail(@ModelAttribute("contact") Contact contact, Model model) {
		
		try {
			String content = "Name: " + contact.getName() + "\n" + "Email: " + contact.getEmail() + "\n" + "Message: " + contact.getContent();
			mailService.sendEmail(contact.getEmail(), toEmail, contact.getSubject(), content);
			model.addAttribute("message", "Email successfully sent!");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		
		return "contact-form";
	}
}
