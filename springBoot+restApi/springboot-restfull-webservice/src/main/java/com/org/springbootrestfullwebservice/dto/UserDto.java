package com.org.springbootrestfullwebservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private Long id;
	@NotEmpty(message = "firstName should not be empty and null")
	private String firstName;
	@NotEmpty( message = "lastName should not be empty and null")
	private String lastName;
	
	@NotEmpty(message = "email should not be empty and null")
	@Email(message = "email should be valid")
	private String email;

}
