package com.example.springTest2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestControlAlternate {
	
	@GetMapping("/")
	public String welcome() {
	    return "Alternate welcome";
	}

	@GetMapping("/say")
	public String greet() {
		return "Alternate hello";
	}
	
	@GetMapping("/test")
	String testString() {
		return "Alternate test string";
	}
}