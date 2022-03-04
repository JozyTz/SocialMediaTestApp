package project.app.model;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String path;
	
	@Column
	private String user;
	
	@Column
	private String comments;
	
	@Column
	private int likes;
	
	@Column
	private int dislikes;
	
	public Post(String title, String path, String user) {
		this.title = title;
		this.path = path;
		this.user = user;
		likes = 0;
		dislikes = 0;
	}
	
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
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	//Want to change to get User object
//	public String getUser() {
//		return user;
//	}
//	
//	public void setUser(String user) {
//		this.user = user;
//	}
	
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
	
	// Want to change to reference comments oject
//	public String getComments() {
//		return comments;
//	}
//	
//	public void setComments(String comments) {
//		this.comments = comments;
//	}
}
