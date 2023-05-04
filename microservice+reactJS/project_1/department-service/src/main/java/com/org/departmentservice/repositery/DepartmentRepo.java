package com.org.departmentservice.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.departmentservice.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
	Department findByDepartmentCode(String code);
	Department findByDepartmentName(String name);

}
