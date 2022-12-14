package project.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.app.model.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByUserId(String userID);
	
	Post findById(long postIdNum);
}
