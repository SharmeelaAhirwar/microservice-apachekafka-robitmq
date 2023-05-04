package com.org.organizationservice.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.organizationservice.entity.Organization;

public interface OrganizationRepo  extends JpaRepository<Organization, Long>{
	
	Organization findByCode(String code);

}
