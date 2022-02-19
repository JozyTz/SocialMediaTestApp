package onetoone.Animals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import onetoone.Animals.Animals;
import onetoone.Animals.AnimalsRepository;

@RestController
public class AnimalsController {
	
	@Autowired
    AnimalsRepository animalsRepository;
    
    private String success = "{\"message\":\"success\"}";
    private String failure = "{\"message\":\"failure\"}";

    @GetMapping(path = "/animals")
    List<Animals> getAllAnimals(){
		return animalsRepository.findAll();
    }

    @GetMapping(path = "/animals/{id}")
    Animals getAnimalsById(@PathVariable int id){
        return animalsRepository.findById(id);
    }

    @PostMapping(path = "/animals")
    String createAnimals(@RequestBody Animals Animals){
        if (Animals == null)
            return failure;
        animalsRepository.save(Animals);
        return success;
    }

    @PutMapping(path = "/animals/{id}")
    Animals updateAnimals(@PathVariable int id, @RequestBody Animals request){
        Animals animals = animalsRepository.findById(id);
        if(animals == null)
            return null;
        animalsRepository.save(request);
        return animalsRepository.findById(id);
    }

    @DeleteMapping(path = "/animals/{id}")
    String deleteAnimals(@PathVariable int id){
        animalsRepository.deleteById(id);
        return success;
    }

}
