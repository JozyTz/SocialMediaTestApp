package project.app.model;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private Long id;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	protected List<User> friends = null;
	
	//@ManyToMany(mappedBy = "friends")
	//protected List<User> befriended = null;
	
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	

	

	public User() {}
	
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
	public Long getID() {
		return id;
	}
	
	public void setID(Long id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public void ID(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addFriend(User user) {
		friends.add(user);
	}
	
	public void removeFriend(User user) {
		friends.remove(user);
	}
	
	public List<User> getFriends() {
		return friends;
	}
	
    @Override
    public String toString() {
        return "UserName: " + username + "\nID: " + id ;
    }

	
}
