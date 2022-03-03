package project.app.model;

import javax.persistence.*;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String commentString;
	
	private int likes;
	private int dislikes;
	

	public String getComment() {
		return commentString;
	}
	
	public void setComment(String commentString) {
		this.commentString = commentString;
	}
	
	
	/**
	 * Like getter/setters
	 */
	public int getLikes() {
		return likes;
	}
	
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	/**
	 * Dislike getter/setters
	 */
	public int getDislikes() {
		return dislikes;
	}
	
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	
}
