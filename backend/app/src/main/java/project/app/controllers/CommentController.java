package project.app.controllers;

import java.util.List;
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

	/**
	 *	Create comment on a post
	 */
	@PostMapping(path = "/comment/{userId}/{postId}")
	public @ResponseBody JSONResponse createComment(@RequestBody Comment comment, @PathVariable("userId") Long userIdNum, @PathVariable("postId") Long postIdNum)
	{
		User tmpUser = userRepo.findById(userIdNum).get();
		Post tmpPost = postRepo.findById(postIdNum).get();
		
		if (tmpUser != null && tmpPost != null)
		{
			//comment.setUser(tmpUser);
			tmpUser.addComment(comment);
			comment.setPost(tmpPost);
			commentRepo.save(comment);
			return new JSONResponse(true, comment);
		}
		else
		{
			return new JSONResponse(false, "Invalid user and/or Post");
		}
	}
	
	
	/**
	 * Delete comment on a post
	 */
	@DeleteMapping(path = "/comment/{commentId}")
	public @ResponseBody JSONResponse deleteComment(@PathVariable("commentId") Long commentIdNum)
	{
		Comment commentToBeDeleted = commentRepo.findById(commentIdNum).get();
		if (commentToBeDeleted != null)
		{
			commentRepo.deleteById(commentIdNum);
			return new JSONResponse(true, "Success");
		}
		else
		{
			return new JSONResponse(false, "Comment does not exist");
		}
	}
	
	
	/**
	 * Like a comment
	 */
	@PostMapping(path = "/comment/{commentId}/like")
	public void likeComment(@PathVariable("commentId") long commentIdNum)
	{
		Comment tmpComment = commentRepo.findById(commentIdNum).get();
		tmpComment.setLikes(tmpComment.getLikes() + 1);
		commentRepo.save(tmpComment);
	}
	
	
	/**
	 * Dislike a comment
	 */
	@PostMapping(path = "/comment/{commentId}/dislike")
	public void dislikeComment(@PathVariable("commentId") long commentIdNum)
	{
		Comment tmpComment = commentRepo.findById(commentIdNum).get();
		tmpComment.setDislikes(tmpComment.getDislikes() + 1);
		commentRepo.save(tmpComment);
	}
	
	
	/**
	 * List all comments by a user
	 */
	@GetMapping(path = "/comment/user/{userId}")
		public List<Comment> getUserComments (@PathVariable("userId") long userIdNum)
	{
			User user = userRepo.findById(userIdNum);
			return user.getComments();
	}


	/**
	* Get all comments on a post
	*/
	@GetMapping(path = "/posts/{postId}/comments")
	public List<Comment> getPostComments (@PathVariable("postId") long postIdNum)
	{
		Post post = postRepo.findById(postIdNum);
		return post.getComments();
	}
}
