package com.example.Codingninjaapplication;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SimpleUser implements User {

	String name;
	String age;
	String location;
	String collegeName;
	
	@Override
	public String getUserDetails() {
		return "Name: "+this.name+" Age: "+this.age;
	}

	@Override
	public void setUserDetails(String name, String age, String location, String collegeName) {
		this.name=name;
		this.age=age;
		this.location=location;
		this.collegeName=collegeName;
	}

}
