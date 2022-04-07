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
public class CommentController {
	
	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PostRepository postRepo;
	
	
	@PostMapping(path = "/comment/{userId}/{postId}")
	public @ResponseBody JSONResponse createComment (@RequestBody Comment comment, @PathVariable("userId") Long userIdNum, @PathVariable("postId") Long postIdNum) {
		
		User tmpUser = userRepo.findById(userIdNum).get();
		Post tmpPost = postRepo.findById(postIdNum).get();
		
		if (tmpUser != null && tmpPost != null) {
			//comment.setUser(tmpUser);
			tmpUser.addComment(comment);
			comment.setPost(tmpPost);
			commentRepo.save(comment);
			return new JSONResponse(true, comment);
		}
		else {
			return new JSONResponse(false, "Invalid user and/or Post");
		}
	}
	
	
	@GetMapping(path = "/users/{userId}/comments")
		public List<Comment> getUserComments (@PathVariable("userId") long userIdNum) {
			User user = userRepo.findById(userIdNum);
			return user.getComments();
	}
	
	@GetMapping(path = "/posts/{postId}/comments")
	public List<Comment> getPostComments (@PathVariable("postId") long postIdNum) {
		Post post = postRepo.findById(postIdNum);
		return post.getComments();
}
}