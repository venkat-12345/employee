package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@RestController
@RequestMapping("/rest")
public class AdminController {

	@Autowired
	private UserRepo userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public String addUserByAdmin(@RequestBody UserDto user) {
		String pwd = user.getUser().getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.getUser().setPassword(encryptPwd);
		userRepository.save(user.getUser());
		return "user added successfully...";
	}

	//@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/all")
	public String securedHello() {
		return "Secured Hello";
	}
}