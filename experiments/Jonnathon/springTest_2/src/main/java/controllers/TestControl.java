package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class TestControl {

	@GetMapping("/")
	public String welcome() {
	    return "Welcome</br> Go to localhost:8080/owners/create to create dummy data </br>";
	}

	@GetMapping("/say")
	public String greet() {
		return "Hello World";
	}
}
