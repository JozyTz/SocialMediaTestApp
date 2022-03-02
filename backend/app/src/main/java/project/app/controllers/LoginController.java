package project.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.app.model.User;
import project.app.repository.UserRepository;

@RestController
public class LoginController {
	
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/users")
	List<User> GetAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> findUserById(@PathVariable Long id) {  
		return userRepository.findById(id);
	}

	
	@PostMapping("/users/create")
	User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@DeleteMapping("/users/{id}")
    String deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return "Success";
	}
	
	@PostMapping(value = "/login", headers = "Accept=application/json")
	String login(@RequestBody User auth) {
		User user = userRepository.findByUsername(auth.getUsername());
		if (user != null) {
			String password = user.getPassword();
			if (password.equals(auth.getPassword())) {
				return user.getID() + "";
			}
			
			else {
				return "Invalid password";
			}
		}
		return "Invalid username";
	}

}
