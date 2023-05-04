package com.org.springbootrestfullwebservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.springbootrestfullwebservice.dto.UserDto;
import com.org.springbootrestfullwebservice.entity.User;
import com.org.springbootrestfullwebservice.exception.EmailAlreadyExistException;
import com.org.springbootrestfullwebservice.repositery.UserRepo;
import com.org.springbootrestfullwebservice.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController()
@RequestMapping("/user")
@Tag(
		name = "crud api for users information",
		description = "create users,update,delete,read users api"
		)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Operation(
			
			summary = "create user ",
			description = "create user",
			method = "post"
			)
	@ApiResponse(
			responseCode = "201 ",
			description = "http status created 201"
			
			)
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser( @Valid @RequestBody UserDto userDto) {
		Optional<User>user=this.userRepo.findByEmail(userDto.getEmail());
		
		if(user.isPresent()) {
			throw new EmailAlreadyExistException("email already exist !! try with another mail !");
		}
		UserDto createdUser=userService.createUser(userDto);
		return new ResponseEntity<UserDto>(createdUser,HttpStatus.CREATED);
		
	
	}
	
	@GetMapping("/getById/{id}")
	
	public ResponseEntity<UserDto> findByUserId(@PathVariable Long id){
		UserDto userDto=userService.getUserById(id);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto>  updateUser( @Valid @RequestBody UserDto user,@PathVariable Long id) {
		UserDto updatedUser=userService.updateUser(user, id);
		return new ResponseEntity<UserDto>(updatedUser,HttpStatus.ACCEPTED);
		
	
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return new ResponseEntity( "user delelted successfull",HttpStatus.OK);
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<UserDto>>getALlUsers(){
		List<UserDto>users=this.userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(users,HttpStatus.OK);
	}
	

}
