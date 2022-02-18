package project.app.model;


import javax.persistence.*;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	

	public User() {}
	
	public User(String username, int id) {
		this.username = username;
		this.id = id;
	}
	
	
	public Integer getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public void setID(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
    @Override
    public String toString() {
        return "UserName: " + username + "\nID: " + id ;
    }

	
}
