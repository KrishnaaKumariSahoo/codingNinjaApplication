package com.example.Codingninjaapplication;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("javaInstructor")
public class JavaInstructor implements Instructor {

	String name;
	int age;
	
	@PostConstruct
	public void init() {
		System.out.println("Java Instructor bean created");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Java Instructor bean about to be destroyed");
	}
	
	@Override
	public void setInstructorDetails(String name, int age) {
		this.name=name;
		this.age=age;
	}

	@Override
	public String takeClass() {
		return "Hi my name is "+ this.name +" and I will be your java instructor.";
	}

}
