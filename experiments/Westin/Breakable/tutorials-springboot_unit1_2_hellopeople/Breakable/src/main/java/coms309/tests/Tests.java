package coms309.tests;

public class Tests {
	private String title;
	private String artist;
	
	public Tests(){
		
    }
	
	public Tests(String title, String artist){
        this.title = title;
        this.artist = artist;
    }
	
	public String getTitle() {
        return this.title;
    }
	
	public void setTitle(String title) {
        this.title = title;
    }
	
	public String getArtist() {
        return this.artist;
    }
	
	public void setArtist(String artist) {
        this.artist = artist;
    }
	
	@Override
    public String toString() {
        return title + ", by: " 
               + artist;
    }

}
