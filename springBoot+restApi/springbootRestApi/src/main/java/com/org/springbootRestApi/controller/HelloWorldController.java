package com.org.springbootRestApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //@controller+@responseBody=@restcontroller
public class HelloWorldController {
	
	
	
	@GetMapping("/helo-world")
	public String helloWolrd() {
		return "hello world";
	}

}
