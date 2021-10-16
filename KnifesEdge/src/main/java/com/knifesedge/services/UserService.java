package com.knifesedge.services;

import java.util.List;

import com.knifesedge.entities.User;

public interface UserService {

	User findByUsername(String username);
	List<User> index();
	
}
