package com.org.springbootrestfullwebservice.services;

import java.util.List;

import com.org.springbootrestfullwebservice.dto.UserDto;
import com.org.springbootrestfullwebservice.entity.User;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	UserDto getUserById(Long userId);
	
	List<UserDto>getAllUsers();
	UserDto updateUser(UserDto user,Long userId);
	void deleteUser(Long userId);

}
