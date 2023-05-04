package com.org.employeeservice.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.employeeservice.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
