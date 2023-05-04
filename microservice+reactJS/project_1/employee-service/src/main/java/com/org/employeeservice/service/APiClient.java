package com.org.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.org.employeeservice.dto.DepartmentDto;



//@FeignClient(url = "http://localhost:8080",value = "Department")  without service-registry

@FeignClient(name = "DEPARTMENT-SERVICE" )  //with service-registry
public interface APiClient {
	
       @GetMapping("/department/byCode/{code}")
	public DepartmentDto getByDepartmentCode(@PathVariable String code);
		
		

}
