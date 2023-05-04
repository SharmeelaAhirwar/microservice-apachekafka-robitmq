package com.org.departmentservice.services;

import java.util.List;

import com.org.departmentservice.dto.DepartmentDto;


public interface DepartmentSer {
	
	DepartmentDto createDepartment(DepartmentDto departmentDto);
	
   DepartmentDto findDepartmentByDepartmentCode(String departmentCode);
	
	DepartmentDto findDepartmentByDepartmentName(String departmentName);
	
	List<DepartmentDto>getAllDepartment();
	
	DepartmentDto updateDepartment(DepartmentDto departmentDto);
	
	void deleteDepartment(Long id);
	
	DepartmentDto getDepartmentById(Long id);

}
