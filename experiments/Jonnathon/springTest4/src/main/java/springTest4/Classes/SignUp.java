package springTest4.Classes;

import java.util.ArrayList;
import java.util.List;

public class SignUp {
	
    private static SignUp form = null;
    private List<Person> people;


    
    private SignUp() {
    	people = new ArrayList<Person>();
    }

    
    public static SignUp getInstance() {

        if (form != null) {
            return form;
            }
        else {
        	form = new SignUp();
            return form;
        }
    }

    public String search(long personid) {
    	for(int i=0; i<people.size(); i++) {
    		Person tmpPerson = people.get(i);
            if (tmpPerson.getID() == personid) {
            	return people.get(i).toString();
            }
    	}
            return "not found";
    }
    
    
    /**
     * add new person to list if the ID is unique
     * @param person
     * @return true if success, false if fail
     */
    public boolean add(Person person) {
    	for(int i=0; i<people.size(); i++) {
    		Person tmpPerson = people.get(i);
            if(tmpPerson.getID() == (person.getID())) {
            	return false;	//add fail
            }
    	}
    	people.add(person);
    	return true;			//add success
    }

    
    /**
     * update output list
     * @param person
     * @return list update status
     */
    public String updateList(Person person) {
        for(int i=0; i<people.size(); i++) {
            Person tmpPerson = people.get(i);
            if(tmpPerson.getID() == (person.getID())) {
                people.set(i, person);
                return "List updated";
            }
        }
        return "List update fail";
    }

    /**
     * delete person by ID
     * @param id
     * @return delete status
     */
    public String deletePerson(long id) {
        for(int i=0; i<people.size(); i++) {
        	Person tmpPerson = people.get(i);
            if(tmpPerson.getID() == (id)){
            	people.remove(i);
                return "Delete success";
            }
        }
        return "Delete fail";
    }

    
    public List<Person> getPeople() {
        return people;
    }

}