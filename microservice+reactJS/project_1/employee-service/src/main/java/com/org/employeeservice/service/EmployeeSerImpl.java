package com.org.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.org.employeeservice.dto.ApiResponseDto;
import com.org.employeeservice.dto.DepartmentDto;
import com.org.employeeservice.dto.EmployeeDto;
import com.org.employeeservice.dto.OrganizationDto;
import com.org.employeeservice.entity.Employee;
import com.org.employeeservice.repositery.EmployeeRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeSerImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	
	ModelMapper modelMapper;
	
//	@Autowired
//	RestTemplate restTemplate;
	
	@Autowired
	WebClient webClient;
	
	
	@Autowired
	APiClient aPiClient;
	
	

	@Override
	public EmployeeDto create(EmployeeDto employeeDto) {
	     Employee employee=this.modelMapper.map(employeeDto, Employee.class);
	     Employee savedEmployee=this.employeeRepo.save(employee);
	     
		return this.modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getById(Long id) {
		Employee employee=this.employeeRepo.findById(id).get();
		
		return this.modelMapper.map(employee, EmployeeDto.class);
	}

//	@CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	@Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	@Override
	public ApiResponseDto getEmployeeByID(Long id) {
		Employee employee=this.employeeRepo.findById(id).get();
//		
//		ResponseEntity<DepartmentDto>responseEntity=restTemplate.getForEntity(
//				"http://localhost:8080/department/byCode/"+employee.getDepartmentCode(), DepartmentDto.class);
//		DepartmentDto Ddto=responseEntity.getBody();
		
		DepartmentDto Ddto=webClient.get()
				.uri("http://localhost:8080/department/byCode/"+employee.getDepartmentCode())
				.retrieve()
				.bodyToMono(DepartmentDto.class)
				.block();
		OrganizationDto Odto=webClient.get()
				.uri("http://localhost:8082/organization/byCode/"+employee.getOrganizationCode())
				.retrieve()
				.bodyToMono(OrganizationDto.class)
				.block();
		
//		DepartmentDto Ddto=aPiClient.getByDepartmentCode(employee.getDepartmentCode());
		EmployeeDto empDto=this.modelMapper.map(employee, EmployeeDto.class);
		ApiResponseDto apiResponseDto=new ApiResponseDto();
		apiResponseDto.setDepartmentDto(Ddto);
		apiResponseDto.setEmployeeDto(empDto);
		apiResponseDto.setOrganizationDto(Odto);
		
		
		
		return apiResponseDto;
	}
	public ApiResponseDto getDefaultDepartment(Long id,Exception ex) {
		Employee employee=this.employeeRepo.findById(id).get();
		
	DepartmentDto Ddto=new DepartmentDto();
	Ddto.setDepartmentCode("111");
	Ddto.setDepartmentName("default");
	Ddto.setDepartmentDesc("deafilt value");
		EmployeeDto empDto=this.modelMapper.map(employee, EmployeeDto.class);
		ApiResponseDto apiResponseDto=new ApiResponseDto();
		apiResponseDto.setDepartmentDto(Ddto);
		apiResponseDto.setEmployeeDto(empDto);
		
		
		
		return apiResponseDto;
		
	}

}
