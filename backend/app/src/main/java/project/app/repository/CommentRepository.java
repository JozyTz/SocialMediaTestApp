package project.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.app.model.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
	
	List<Comment> findByid(String userID);
	
	//List<Comment> findByPost(String post);
}

