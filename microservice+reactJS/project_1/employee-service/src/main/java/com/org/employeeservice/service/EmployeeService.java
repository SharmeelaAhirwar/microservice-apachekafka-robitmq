package com.org.employeeservice.service;

import com.org.employeeservice.dto.ApiResponseDto;
import com.org.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	
	public EmployeeDto create(EmployeeDto employeeDto);
	public EmployeeDto getById(Long id);
	
	public ApiResponseDto getEmployeeByID(Long id);

}
