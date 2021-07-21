package com.example.demo.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.entity.common.UserConstant;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	private final UserRepo userRepo;
    protected static final String DEFAULT_ROLE = "ROLE_USER";	
    protected static final String[] ADMIN_ACCESS = {"ROLE_ADMIN"};
    
	public UserController(UserService userService, UserRepo userRepo) {
		this.userService=userService;
		this.userRepo = userRepo;
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addNewUser(@RequestBody UserDto user){
		user.getUser().setRoles(UserConstant.DEFAULT_ROLE);
		User newuser = userService.addNewUser(user.getUser());
			return new ResponseEntity <>(newuser,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity <List<User>>viewUsers(){
		List<User> users=userService.viewUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	

  @GetMapping("/test")
 @PreAuthorize("hasAuthority('ROLE_USER')")
  public String testUserAccess() {
      return "user can only access this !";
  }
  
	@PostMapping("/signin")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public ResponseEntity<String> signin(@RequestBody UserDto user){
		String msg = userService.signin(user.getUser());
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<User> signout(){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/forgotpassword")
	public ResponseEntity<String>forgotPassword(@RequestBody User user){
		String msg=userService.forgotPassword(user);
		return new ResponseEntity <> (msg,HttpStatus.OK);
	}
	
	 private User getLoggedInUser(Principal principal) {
	        return userRepo.findByUsername(principal.getName()).get();
	    }
	 
	 private List<String> getRolesByLoggedInUser(Principal principal) {
	        String roles = getLoggedInUser(principal).getRoles();
	        List<String> assignRoles = Arrays.stream(roles.split(",")).collect(Collectors.toList());
	        if (assignRoles.contains("ROLE_ADMIN")) {
	            return Arrays.stream(UserConstant.ADMIN_ACCESS).collect(Collectors.toList());
	        }
	        
	        return Collections.emptyList();
	    }
	 
	 @GetMapping("/access/{userId}/{userRole}")
	    //@Secured("ROLE_ADMIN")
	    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	    public String giveAccessToUser(@PathVariable int userId, @PathVariable String userRole, Principal principal) {
	        User user = userRepo.findById(userId).get();
	        user.setRoles(userRole);
	        userRepo.save(user);
	        return "Hi " + user.getUsername() + " New Role assign to you by " + principal.getName();
	    }
	 
	 
}