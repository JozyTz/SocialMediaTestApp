package project.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.app.model.User;
import project.app.repository.UserRepository;

@RestController
public class LoginController {
	
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("users/all")
	List<User> GetAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public Optional<User> findUserById(@PathVariable Long id) {  
		return userRepository.findById(id);
	}

	
	@PostMapping("/users/create")
	User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@DeleteMapping("/users/{id}")
    String deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
        return "Success";
	}

}
