package com.org.organizationservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.organizationservice.dto.OrganizationDto;
import com.org.organizationservice.entity.Organization;
import com.org.organizationservice.repositery.OrganizationRepo;
@Service
public class OrganizationServiceImpl implements OrganizationService{
	
	
	@Autowired
	OrganizationRepo organizationRepo;
	
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public OrganizationDto createOrganization(OrganizationDto organizationDto) {
		Organization organization=this.modelMapper.map(organizationDto, Organization.class);
		Organization created=this.organizationRepo.save(organization);
		OrganizationDto dto=this.modelMapper.map(created, OrganizationDto.class);
		
		return dto;
	}

	@Override
	public OrganizationDto getOrganizationByCode(String code) {
		Organization savedOrganization=this.organizationRepo.findByCode(code);
		return this.modelMapper.map(savedOrganization, OrganizationDto.class);
	}

}
