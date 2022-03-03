package project.app.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String username;
	
	@Column
	private String commentString;
	
	@Column
	private int likes;
	
	@Column
	private int dislikes;
	

	/**
	 * Comment constructor
	 * @param username
	 * @param commentString
	 */
	public Comment(String username, String commentString) {
		this.username = username;
		this.commentString = commentString;
		likes = 0;
		dislikes = 0;
	}
	
	
	/**
	 * username getter/setters
	 */
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	/**
	 * Comment getter/setters
	 */
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
