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
	
	@PostMapping(path = "/post/{user_id}")
	public @ResponseBody JSONResponse createPost (@RequestBody Post post, @PathVariable("userId") Long userIdNum) {
		
		User tmpUser = userRepo.findById(userIdNum).get();
		
		if (tmpUser != null) {
			tmpUser.addPost(post);
			postRepo.save(post);
			return new JSONResponse(true, post);
		}
		else {
			return new JSONResponse(false, "Invalid User");
		}
	}
	
	
	@GetMapping("/users/{user_id}/posts")
	public List<Post> getUserPosts (@PathVariable ("user_id") long userIdNum) {  
		User user = userRepo.findByUserId(userIdNum);
		return user.getPosts();
	}
	
	
	
}
