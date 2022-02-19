package project.app.controllers;

import java.util.List;

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
	
	@GetMapping("users/{id}")
	List<User> GetUserByID(){
		return userRepository.findAll();
		//TODO
	}
	
	@PostMapping("/users/create")
	User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
//	@DeleteMapping("/users/{id}") 
//    public @ResponseBody HashMap<String, Tests> deleteSong(@PathVariable String title) {
//        songList.remove(title);
//        return songList;
//    }
}
