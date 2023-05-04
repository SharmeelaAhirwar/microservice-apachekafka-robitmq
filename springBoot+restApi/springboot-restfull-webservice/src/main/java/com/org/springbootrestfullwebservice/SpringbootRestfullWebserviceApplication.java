package com.org.springbootrestfullwebservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		
		info=@Info(
				title="spring boot application",
				description="spring boot restfull application",
				version="v1.0",
				contact=@Contact(
						name="sharmeela",
						email="sharmeela@gmail.com",
						url="url"
						),
				license=@License(
						name="Apache 2.0",
						url="url"
						)
				
				
				),
		externalDocs = @ExternalDocumentation(
				description = "spring boot",
				url = "url"
				)
		
		
		)

public class SpringbootRestfullWebserviceApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebserviceApplication.class, args);
		
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}

}
