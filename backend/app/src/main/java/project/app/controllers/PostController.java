package project.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.app.model.Comment;
import project.app.model.Post;
import project.app.model.User;
import project.app.repository.CommentRepository;
import project.app.repository.PostRepository;
import project.app.repository.UserRepository;
import project.app.util.JSONResponse;

@RestController
public class PostController {

	@Autowired
	PostRepository postRepo;
	
	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	
	
	@GetMapping("/post/{id}")
	public Optional<Post> findUserById(@PathVariable Long id) {  
		return postRepo.findById(id);
	}
	
	
	
}
