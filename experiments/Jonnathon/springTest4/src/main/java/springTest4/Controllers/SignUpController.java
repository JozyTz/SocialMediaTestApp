package springTest4.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springTest4.Classes.*;

@RestController
public class SignUpController {

	/**
	 * add person with put/post
	 * @param person
	 * @return	person added
	 */
    @RequestMapping(value="/register/add")
    public String registerPerson(@RequestBody Person person) {

        if (SignUp.getInstance().add(person) == true) {
            SignUp.getInstance().updateList(person);
            return person.toString() + "\nsuccessfully registered";
        }
        return person.toString() + " register fail";
    }
    

    /**
     * delete person with put/post
     * @param person
     * @return	person deleted
     */
    @RequestMapping(value="/register/delete")
    public String deletePerson(@RequestBody Person person) {
    	SignUp.getInstance().deletePerson(person.getID());
    	return person.toString() + "\ndeleted";
    }

}