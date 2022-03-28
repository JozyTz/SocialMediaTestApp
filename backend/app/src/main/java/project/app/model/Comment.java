package project.app.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Comment")
@Table(name = "comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
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
	public Comment(User user) {
		this.user = user;
	}
	
	public Comment() {}
	
	
	/**
	 * username getter/setters
	 */
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
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
