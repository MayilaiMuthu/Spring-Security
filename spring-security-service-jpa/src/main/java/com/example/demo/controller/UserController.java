package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/test")
	public String test() {
		return "welcome to spring security User Controller @JPA method";
	}

}
