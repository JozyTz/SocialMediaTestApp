package project.app.model;

import java.util.List;

import javax.persistence.*;

//@Entity(name = "Song")
//@Table(name = "songs")
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String uploadDate;
	
	@Column
	private String key;
	
	
	public Song(Long id, String key) {
		this.key = key;
	}
	
	public Song() {}
	
	
	/**
	 * Key getter/setters
	 */
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Upload date getter/setters
	 */
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
}
