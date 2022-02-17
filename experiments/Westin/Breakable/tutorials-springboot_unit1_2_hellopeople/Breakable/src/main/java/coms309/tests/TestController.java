package coms309.tests;

import java.util.HashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import coms309.tests.Tests;

@RestController
public class TestController {

	HashMap<String, Tests> songList = new  HashMap<>();
	
	@GetMapping("/songlist")
    public @ResponseBody HashMap<String, Tests> getAllSongs() {
        return songList;
    }
	
	@PostMapping("/song")
    public @ResponseBody String createPerson(@RequestBody Tests song) {
        System.out.println(song);
        songList.put(song.getTitle(), song);
        return "New song "+ song.getTitle() + " Saved";
    }
	
	@GetMapping("/song/{title}")
    public @ResponseBody Tests getSong(@PathVariable String title) {
        Tests s = songList.get(title);
        return s;
    }
	
	@PutMapping("/song/{title}")
    public @ResponseBody Tests updateSong(@PathVariable String title, @RequestBody Tests s) {
        songList.replace(title, s);
        return songList.get(title);
    }
	
	@DeleteMapping("/song/{title}")
    public @ResponseBody HashMap<String, Tests> deleteSong(@PathVariable String title) {
        songList.remove(title);
        return songList;
    }
	
	@GetMapping("/songlist/contains/{title}")
    public @ResponseBody Boolean containsSong(@PathVariable String title) {
        boolean contains;
        if (songList.containsKey(title) == true) {
        	contains = true;
        }
        else {
        	contains = false;
        }
        return contains;
    }
}