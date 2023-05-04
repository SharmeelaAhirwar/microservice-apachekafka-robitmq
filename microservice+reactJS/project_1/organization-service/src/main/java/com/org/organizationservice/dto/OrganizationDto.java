package com.org.organizationservice.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
	
	private Long id;

     private String name;
	
	
	private String description;
	
	private String code;
	
	
	private LocalDate createdDate;
}
