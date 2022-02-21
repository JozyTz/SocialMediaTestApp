package springTest4.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springTest4.Classes.*;

@RestController
public class PersonController {

	/**
	 * show all people registered
	 * @return all people
	 */
    @RequestMapping(path ="/people/allpeople")
    public List<Person> getAllPeople() {
        return SignUp.getInstance().getPeople();
    }
    
    
    /**
     * show info on a single person by their ID
     * @param personID
     * @return specified person
     */
    @RequestMapping(path ="/people/{personID}")
    public String getPerson(@PathVariable("personID") long personID) {
    	
    	return SignUp.getInstance().search(personID);
    }

}
