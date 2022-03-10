package project.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.app.model.User;
import project.app.util.JSONResponse;
import project.app.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping(path = "users/{userId}/addFriend/{friendId}")
	public @ResponseBody JSONResponse addFriend(@PathVariable("userId") long userIdNum, @PathVariable("friendId") long friendIdNum) {
		
		User user = userRepository.findById(userIdNum);
		User friendToAdd = userRepository.findById(friendIdNum);
		
		if (user != null && friendToAdd != null && friendToAdd != user && !user.getFriends().contains(friendToAdd)) {
			user.addFriend(friendToAdd);
			friendToAdd.addFriend(user);
			userRepository.save(user);
			userRepository.save(friendToAdd);
			
			return new JSONResponse(true, friendToAdd);
		}
		else { 
			return new JSONResponse(false, "Invalid user(s)");
		}
	}
	
	@PostMapping(path = "users/{userId}/removeFriend/{friendId}")
	public @ResponseBody JSONResponse removeFriend(@PathVariable("userId") long userIdNum, @PathVariable("friendId") long friendIdNum) {
		
		User user = userRepository.findById(userIdNum);
		User friendToAdd = userRepository.findById(friendIdNum);
		
		if (user != null && friendToAdd != null) {
			user.removeFriend(friendToAdd);
			friendToAdd.removeFriend(user);
			userRepository.save(user);
			userRepository.save(friendToAdd);
			
			return new JSONResponse(true, friendToAdd);
		}
		else { 
			return new JSONResponse(false, "Invalid user(s)");
		}
	}
	
	@GetMapping(path = "users/{userId}/friends")
	public List<User> getFriends(@PathVariable("userId") long userIdNum) {
		User user = userRepository.findById(userIdNum);
		return user.getFriends();
	}
}
