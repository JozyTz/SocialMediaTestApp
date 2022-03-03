package project.app.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.app.model.User;
import project.app.repository.UserRepository;
import project.app.util.JSONResponse;

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
	
//	@PostMapping(value = "/login", produces = "application/json")
//	User login(@RequestBody User auth) {
//		User user = userRepository.findByUsername(auth.getUsername(), auth.getPassword());
//		if (user != null) {
//			String password = user.getPassword();
//			if (password.equals(auth.getPassword())) {
//				return user;
//			}
//			
//			else {
//				System.out.println("Invalid password");
//				return null;
//			}
//		}
//		System.out.println("Invalid user");
//		return null;
//	}
	
	/**
	 * Login with json output for both success and fail
	 * @param auth
	 * @return
	 */
	@PostMapping(value = "/login")
	public @ResponseBody  JSONResponse login(@RequestBody Map<String, Object> auth) {
		User user = userRepository.findByUsernameAndPassword((String) auth.get("username"),
				(String) auth.get("password"));
		
		if (user != null) {
			return new JSONResponse(true, user);
		}

		return new JSONResponse(false, "Invalid user/pass");
	}
}
