package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDetailsDto;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService service;

	@GetMapping("/test")
	public String test() {
		return "welcome to spring security Login Controller @JPA method";
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody @Valid UserDetailsDto details) {
		ResponseEntity<String> responseEntity = null;
		try {
			service.addUser(details);
			responseEntity = new ResponseEntity<>("User Added.......", HttpStatus.CREATED);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

}
