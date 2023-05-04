package com.org.springbootrestfullwebservice.repositery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.springbootrestfullwebservice.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	 Optional <User>findByEmail(String email);

}
