package com.kylejudd.football.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class DemoController {
	
	@GetMapping("/")
	public String home() {
		return "landing-page";
	}
	
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/admin")
	public String adminPage() {
		return "admin";
	}
}
