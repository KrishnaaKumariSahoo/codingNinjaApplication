package com.example.Codingninjaapplication;

import org.springframework.stereotype.Component;

@Component("springInstructor")
public class SpringInstructor implements Instructor {

	String name;
	int age;
	
	public void init() {
		System.out.println("Spring Instructor bean created");
	}
	
	public void destroy() {
		System.out.println("Spring Instructor bean about to be destroyed");
	}
	
	@Override
	public void setInstructorDetails(String name, int age) {
		this.name=name;
		this.age=age;
	}

	@Override
	public String takeClass() {
		return "Hi my name is "+ this.name +" and I will be your spring instructor.";
	}

}
