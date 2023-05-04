package com.org.organizationservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.organizationservice.dto.OrganizationDto;
import com.org.organizationservice.service.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
	
	@Autowired
	OrganizationService organizationService;
	
	@PostMapping("/create")
	public ResponseEntity<OrganizationDto>create(@RequestBody OrganizationDto organizationDto){
		OrganizationDto createdOrganizationDto=this.organizationService.createOrganization(organizationDto);
		return new ResponseEntity<OrganizationDto>(createdOrganizationDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/byCode/{code}")
	public ResponseEntity<OrganizationDto>getByCode(@PathVariable String code){
		OrganizationDto organizationDto=this.organizationService.getOrganizationByCode(code);
		return new ResponseEntity<OrganizationDto>(organizationDto,HttpStatus.OK);
	}

}
