package project.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.app.model.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	List<Comment> findByUserId(Long userID);
	
	List<Comment> findByPostId(Long postId);
	
	Optional<Comment> findById(Long commentId);
	
	Comment findByMessage(String message);
	
	void deleteById(int id);

}

