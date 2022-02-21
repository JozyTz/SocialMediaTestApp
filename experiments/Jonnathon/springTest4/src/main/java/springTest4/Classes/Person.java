package springTest4.Classes;

public class Person {
	
    long id;
    String name;
    int age;
    
    public long getID() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
    	return "Name: " + name + ", Age: " + age + ", ID: " + id;
    }
}