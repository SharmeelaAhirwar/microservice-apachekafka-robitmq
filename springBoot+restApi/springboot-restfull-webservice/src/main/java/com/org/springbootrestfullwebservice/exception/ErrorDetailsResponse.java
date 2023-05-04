package com.org.springbootrestfullwebservice.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetailsResponse {
	
	private LocalDateTime localTime;
	
	private String message;
	
	private String path;
	private String errorCode;

}
