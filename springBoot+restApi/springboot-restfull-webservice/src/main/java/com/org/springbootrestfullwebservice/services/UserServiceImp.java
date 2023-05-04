package com.org.springbootrestfullwebservice.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.org.springbootrestfullwebservice.dto.UserDto;
import com.org.springbootrestfullwebservice.entity.User;
import com.org.springbootrestfullwebservice.exception.ResourceNotFoundException;
import com.org.springbootrestfullwebservice.repositery.UserRepo;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired 
	 private UserRepo userRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.modelMapper.map(userDto, User.class);
		User savedUser=this.userRepo.save(user);
		return this.modelMapper.map(savedUser, UserDto.class);
		
		
	 
	}

	@Override
	public UserDto getUserById(Long userId) {
		User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
		
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		
		List<User>users=this.userRepo.findAll();
		List<UserDto>dtos=users.stream().map((user)->modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {
		User savedUser=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
		
		
		savedUser.setEmail(userDto.getEmail());
		savedUser.setFirstName(userDto.getFirstName());
		savedUser.setLastName(userDto.getLastName());
		User updateuser=userRepo.save(savedUser);
		
		return  this.modelMapper.map(updateuser, UserDto.class);
	}

	@Override
	public void deleteUser(Long userId) {
		 User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
		
		this.userRepo.delete(user);
		
	}
	
//	private static User convertUserDtoToUser(UserDto userDto) {
//		 User user=new User();
//		 user.setEmail(userDto.getEmail());
//		 user.setFirstName(userDto.getFirstName());
//		 user.setLastName(userDto.getLastName());
//		 return user;
//	}
//
//	private static UserDto convertUserToUserDto(User user) {
//		 UserDto userDto=new UserDto();
//		 userDto.setEmail(user.getEmail());
//		 userDto.setFirstName(user.getFirstName());
//		 userDto.setLastName(user.getLastName());
//		 return userDto;
//	}

}
