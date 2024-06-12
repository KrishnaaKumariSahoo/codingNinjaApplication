package com.example.Codingninjaapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PaidCourse implements Course {
	
	String courseName;
	Instructor courseInstructor;
	
	@Autowired
	@Qualifier("javaInstructor")
	Instructor javaInstructor;
	
	@Autowired
	@Qualifier("springInstructor")
	Instructor springInstructor;
	 
	@Autowired
	UserList userList;

	//constructor injection
//	public PaidCourse(Instructor courseInstructor,UserList userList)
//	{
//		this.courseInstructor=courseInstructor;
//		this.userList=userList;
//	}
	
	@Override
	public void setCourseDetail(String courseName) {
		this.courseName=courseName;
	}

	@Override
	public UserList getUserList() {
		return this.userList;
	}

	@Override
	public Instructor getInstructor() {
		return this.courseInstructor;
	}

	@Override
	public String getCourseName() {
		return this.courseName;
	}
	
	public void setInstructor(String instructorType)
	{
		if(instructorType.equals("java"))
			this.courseInstructor=this.javaInstructor;
		else
			this.courseInstructor=this.springInstructor;
	}

}
