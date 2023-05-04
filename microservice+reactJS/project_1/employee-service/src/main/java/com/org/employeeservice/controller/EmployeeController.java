package com.org.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.employeeservice.dto.ApiResponseDto;
import com.org.employeeservice.dto.EmployeeDto;
import com.org.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping("/create")
	public   ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savDto=this.employeeService.create(employeeDto);
		return new ResponseEntity<EmployeeDto>(savDto,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/byId/{id}")
	public   ResponseEntity<ApiResponseDto> getEmployee(@PathVariable Long id) {
		ApiResponseDto savDto=this.employeeService.getEmployeeByID(id);
		return new ResponseEntity<ApiResponseDto>(savDto,HttpStatus.OK);
		
	}

}
