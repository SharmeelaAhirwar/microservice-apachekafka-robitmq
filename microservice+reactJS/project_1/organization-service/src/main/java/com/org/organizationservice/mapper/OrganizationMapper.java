package com.org.organizationservice.mapper;

import com.org.organizationservice.dto.OrganizationDto;
import com.org.organizationservice.entity.Organization;

public class OrganizationMapper {
	
	public static OrganizationDto organizationToOrganizationDto(Organization organization) {
		
		OrganizationDto organizationDto=new OrganizationDto();
		organizationDto.setCode(organization.getCode());
		organizationDto.setName(organization.getName());
		organizationDto.setId(organization.getId());
		organizationDto.setDescription(organization.getDescription());
		organizationDto.setCreatedDate(organization.getCreatedDate());
		
		return organizationDto;
	}
	
public static Organization organizationDtoToOrganization(OrganizationDto organizationDto) {
		
		Organization organization=new Organization();
		organization.setCode(organizationDto.getCode());
		organization.setName(organizationDto.getName());
		organization.setId(organizationDto.getId());
		organization.setDescription(organizationDto.getDescription());
		organization.setCreatedDate(organizationDto.getCreatedDate());
		
		return organization;
	}

}
