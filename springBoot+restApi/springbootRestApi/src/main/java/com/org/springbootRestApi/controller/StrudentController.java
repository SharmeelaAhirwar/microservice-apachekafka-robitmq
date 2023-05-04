package com.org.springbootRestApi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.springbootRestApi.bean.Student;

@RestController
public class StrudentController {
	
	
	
	@GetMapping("/student")
	public Student getStudent() {
		Student student=new Student(1, "sharmeela","ahirwar");
		return student;
	}
	@GetMapping("/student-list")
	public List<Student>getListOfStudent(){
		List list=new ArrayList<Student>();
		list.add(new Student(1, "stu1", "stu1"));
		list.add(new Student(2, "stu2", "stu2"));
		list.add(new Student(3, "stu3", "stu3"));
		list.add(new Student(4, "stu4", "stu4"));
		return list;
		
	}
	
	//spring boot rest api with path  variable
	@GetMapping("/studentId/{id}")
	public Student getStudentById(@PathVariable int id) {
		return new Student(id, "shrmi","shrmi");
	}
	
	
	@GetMapping("/studentId/{id}/{firstName}/{lastName}")
	public Student getStudentByIdFirstNameLastNAme(@PathVariable int id,@PathVariable String firstName,
			@PathVariable String lastName) {
		return new Student(id, firstName,lastName);
	}
	
	//rest api with request param
	@GetMapping("/student/query")
	public Student getStudentByQueryParam( @RequestParam int  id) {
		return new Student(id, "shrmi","shrmi");
	}

}
