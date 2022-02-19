package onetoone.Animals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import onetoone.Users.User;

@Entity
public class Animals {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double weight;
    private int age;
    private String species;
    private int cost;
    
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public int getAge() {
    	return age;
    }
    public void setAge(int age) {
    	this.age = age;
    }
    public String getSpecies() {
    	return species;
    }
    public void setSpecies(String species) {
    	this.species = species;
    }
    public int getCost() {
    	return cost;
    }
    public void setCost(int cost) {
    	this.cost = cost;
    }
}
