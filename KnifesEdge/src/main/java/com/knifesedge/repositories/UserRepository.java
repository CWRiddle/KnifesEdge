package com.knifesedge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knifesedge.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUsername (String username);

}
