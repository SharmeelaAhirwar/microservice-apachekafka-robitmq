package com.org.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.departmentservice.dto.DepartmentDto;
import com.org.departmentservice.services.DepartmentSer;

@RestController
@RequestMapping("/department")

public class DepartmentController {
	
	@Autowired
	DepartmentSer departmentSer;
	
	
	@PostMapping("/create")
	public ResponseEntity<DepartmentDto>createD(@RequestBody DepartmentDto departmentDto){
		DepartmentDto cDepartmentDto=this.departmentSer.createDepartment(departmentDto);
		
		return new ResponseEntity<DepartmentDto>(cDepartmentDto,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/byCode/{code}")
	
	public ResponseEntity<DepartmentDto>getByDepartmentCode(@PathVariable String code){
		
		DepartmentDto savDepartmentDto=this.departmentSer.findDepartmentByDepartmentCode(code);
		return new ResponseEntity<DepartmentDto>(savDepartmentDto,HttpStatus.OK);
		
	}
}
