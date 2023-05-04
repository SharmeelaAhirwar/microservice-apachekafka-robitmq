package com.org.departmentservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.departmentservice.dto.DepartmentDto;
import com.org.departmentservice.entity.Department;
import com.org.departmentservice.repositery.DepartmentRepo;

@Service
public class DepartmentSerImpl implements DepartmentSer {
	
	@Autowired
	DepartmentRepo departmentRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		//convert departmentDto to department
		
		Department createdDepartment=this.modelMapper.map(departmentDto, Department.class);
		Department saved=this.departmentRepo.save(createdDepartment);
		DepartmentDto dto=this.modelMapper.map(saved, DepartmentDto.class);
		
		return dto;
	}

	@Override
	public DepartmentDto findDepartmentByDepartmentCode(String departmentCode) {
		 Department savDepartment =this.departmentRepo.findByDepartmentCode(departmentCode);
		
		
		return this.modelMapper.map(savDepartment, DepartmentDto.class);
		
	}

	@Override
	public DepartmentDto findDepartmentByDepartmentName(String departmentName) {
     Department savDepartment =this.departmentRepo.findByDepartmentName(departmentName);
		
		
		
     return this.modelMapper.map(savDepartment, DepartmentDto.class);
	}

	@Override
	public List<DepartmentDto> getAllDepartment() {
		List<Department>lists=this.departmentRepo.findAll();
		List<DepartmentDto>dtos=lists.stream().map((list)->modelMapper.map(list, DepartmentDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DepartmentDto getDepartmentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
