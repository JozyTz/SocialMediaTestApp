package project.app.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity(name="Post")
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String message;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
	
	@Column
	private int likes;
	
	@Column
	private int dislikes;
	
	@OneToMany
	private List<Comment> comments;
	
	
	public Post(Long id, String title, String message, User user) {
		this.id = id;
		this.title = title;
		this.message = message;
		this.user = user;
		likes = 0;
		dislikes = 0;
	}
	
	public Post() {}
	
	
	
	public Long getID() {
		return id;
	}
	public void setID(Long id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}

	
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	
	public void addComment(Comment comment) {
		comments.add(comment);
		comment.setPost(this);
	}
	
	public void removeComment(Comment comment) {
		comments.remove(comment);
		comment.setPost(null);
	}
	
	public List<Comment> getComments(){
		return comments;
	}
}

