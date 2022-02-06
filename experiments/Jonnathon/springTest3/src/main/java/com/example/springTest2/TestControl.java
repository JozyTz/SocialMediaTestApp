package com.example.springTest2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController


@RequestMapping("/home")
public class TestControl {

	//wildcard, anything after /home returns this
	@GetMapping("*")
	public String welcome() {
	    return "Home welcome";
	}

	@GetMapping("/say")
	public String greet() {
		return "home hello";
	}
	
	@GetMapping("/test")
	String testString() {
		return "home test";
	}
}
