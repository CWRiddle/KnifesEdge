package com.knifesedge.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knifesedge.entities.User;
import com.knifesedge.repositories.UserRepository;
import com.knifesedge.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository uRepo;
	
	@Autowired
	UserService uService;
	
	@GetMapping("ping")
	private String ping() {
		return "pong";
	}
	
	@GetMapping("api/user/index")
	private List<User> index(HttpServletResponse res, Principal principal){
		
		System.out.println("---------------------------------");
		System.out.println("In user controller index method");
		System.out.println("---------------------------------");
		
		if (uService.findByUsername(principal.getName()) != null) {
			return uRepo.findAll();
		}
		else {
			return null;
		}
	}
	
	@GetMapping("api/user/all")
	public List<User> getAllUser(HttpServletResponse res, Principal principal) {
		if ((uService.findByUsername(principal.getName()).getRole().equals("admin"))) {
			return uService.index();
		}
		else {
			return null;
		}
	}

}
