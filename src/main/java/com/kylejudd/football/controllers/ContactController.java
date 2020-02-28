package com.kylejudd.football.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@GetMapping("/contactForm")
	public String contactForm() {
		return "contact-form";
	}
}
