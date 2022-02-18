package com.example.springTest2;

public class Person {
	
	private Integer age;
	private String name;
	
	public Person() {
		this.age = -1;
		this.name = "";
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}