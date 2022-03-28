package project.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.app.model.Comment;
import project.app.model.User;
import project.app.repository.CommentRepository;
import project.app.repository.UserRepository;

@RestController
public class CommentController {
	
	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	@PostMapping(path = "/post/comment/create")
	public Comment createComment (@RequestBody Comment comment) {
		return commentRepo.save(comment);
	}
	
	@GetMapping(path = "/users/{userId}/comments")
		public List<Comment> getUserComments (@PathVariable("userId") long userIdNum) {
			User user = userRepo.findById(userIdNum);
			return user.getComments();
	}
}