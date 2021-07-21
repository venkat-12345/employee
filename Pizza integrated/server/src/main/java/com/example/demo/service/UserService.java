package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;


	
@Service
@Transactional
public class UserService {
	
	private final UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
		
	}

	public User addNewUser(User user) {
		String pwd = user.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		return this.userRepo.save(user);
		
	}

	public List<User> viewUsers() {
		return userRepo.findAll();
	}

	public String signin(User user) {
		
		return "Welcome "+user.getUsername()+" ,you have successfully logged in!!";
	}

	public BCryptPasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public UserRepo getUserRepo() {
		return userRepo;
	}


	public String forgotPassword(User user) {
		User ruser=userRepo.getById(user.getUserid());
		String newpwd=user.getPassword();
		String encryptPwd = passwordEncoder.encode(newpwd);
		ruser.setPassword(encryptPwd);
		return "Password reset Successfull";
	
		
	}
	

	

	

}