package com.org.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {
	
	EmployeeDto employeeDto;
	DepartmentDto departmentDto;
	OrganizationDto organizationDto;

}
