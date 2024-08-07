package com.yinyang_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String hello() {
		return "<h1>hello</h1>";
	}
	
	@GetMapping("/hello")
	public String hello02() {
		return "<h1>hello</h1>";
	}


}