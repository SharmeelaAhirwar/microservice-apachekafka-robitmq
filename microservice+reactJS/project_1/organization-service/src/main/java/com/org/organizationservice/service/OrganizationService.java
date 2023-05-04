package com.org.organizationservice.service;

import com.org.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
	
	public OrganizationDto createOrganization(OrganizationDto organizationDto);
	
	public OrganizationDto getOrganizationByCode(String code);

}
