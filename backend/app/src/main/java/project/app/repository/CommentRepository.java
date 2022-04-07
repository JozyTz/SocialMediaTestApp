package project.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.app.model.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	List<Comment> findByUserId(Long userID);
	
	List<Comment> findByPostId(Long postId);
}

