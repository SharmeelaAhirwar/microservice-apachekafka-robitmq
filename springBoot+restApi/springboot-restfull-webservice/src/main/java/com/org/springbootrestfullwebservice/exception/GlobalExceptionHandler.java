package com.org.springbootrestfullwebservice.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetailsResponse>handleResouceNotFoundException(ResourceNotFoundException ex,WebRequest webRequest)
	{
		ErrorDetailsResponse errorDetailsResponse=new ErrorDetailsResponse();
		errorDetailsResponse.setErrorCode("USER_NOT_FOUND");
		errorDetailsResponse.setLocalTime(LocalDateTime.now());
		errorDetailsResponse.setMessage(ex.getMessage());
		errorDetailsResponse.setPath(webRequest.getDescription(false));
		return  new ResponseEntity<ErrorDetailsResponse>(errorDetailsResponse,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(EmailAlreadyExistException.class)
	public ResponseEntity<ErrorDetailsResponse>handleEmailALreadyExistException(EmailAlreadyExistException ex,WebRequest webRequest)
	{
		ErrorDetailsResponse errorDetailsResponse=new ErrorDetailsResponse();
		errorDetailsResponse.setErrorCode("Emaily already exist !!");
		errorDetailsResponse.setLocalTime(LocalDateTime.now());
		errorDetailsResponse.setMessage(ex.getMessage());
		errorDetailsResponse.setPath(webRequest.getDescription(false));
		return  new ResponseEntity<ErrorDetailsResponse>(errorDetailsResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetailsResponse>handleEmailALreadyExistException(Exception ex,WebRequest webRequest)
	{
		ErrorDetailsResponse errorDetailsResponse=new ErrorDetailsResponse();
		errorDetailsResponse.setErrorCode("Internal_server_error");
		errorDetailsResponse.setLocalTime(LocalDateTime.now());
		errorDetailsResponse.setMessage(ex.getMessage());
		errorDetailsResponse.setPath(webRequest.getDescription(false));
		return  new ResponseEntity<ErrorDetailsResponse>(errorDetailsResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		
		Map<String,String>errors=new HashMap<>();
		List<ObjectError>errorList=ex.getBindingResult().getAllErrors();
		errorList.forEach((error)->{
			String fieldName=((FieldError)error).getField();
			String msg=error.getDefaultMessage();
			errors.put(fieldName, msg);
		});
		
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
}
