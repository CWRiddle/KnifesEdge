package com.knifesedge.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.knifesedge.entities.User;
import com.knifesedge.services.AuthService;
import com.knifesedge.services.UserService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;
	@Autowired
	private UserService uService;
	
	
	
	@PostMapping("register")
	public User register(@RequestBody User user, HttpServletResponse res) {

	    if (user == null) {
	        res.setStatus(400);
	    }

	    user = authService.register(user);

	    return user;
	}

	@GetMapping("authenticate")
	public User authenticate(Principal principal) {
		
	    return uService.findByUsername(principal.getName());
	}

	
}
