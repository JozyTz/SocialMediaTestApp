package project.app.model;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity(name = "Comment")
@Table(name = "comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnore
    private Post post;
	
	@Column
	private String message;
	
	@Column
	private int likes;
	
	@Column
	private int dislikes;
	

	public Comment(Long id, User user, Post post, String message) {
		this.user = user;
		this.message = message;
	}
	
	public Comment() {}
	
	
	public Long getId() {
		return id;
	}
	
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
	 * post getter/setters
	 */
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
	/**
	 * Comment getter/setters
	 */
	public String getComment() {
		return message;
	}
	public void setComment(String message) {
		this.message = message;
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
