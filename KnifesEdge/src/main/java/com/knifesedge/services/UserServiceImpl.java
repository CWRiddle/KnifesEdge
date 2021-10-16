package com.knifesedge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.knifesedge.entities.User;
import com.knifesedge.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired 
	private PasswordEncoder passEncode;

	@Override
	public User findByUsername(String username) {
		return uRepo.findByUsername(username);
	}
	
	@Override
	public List<User> index(){
		return uRepo.findAll();
	}

}
