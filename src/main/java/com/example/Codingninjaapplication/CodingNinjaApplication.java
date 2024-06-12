package com.example.Codingninjaapplication;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class CodingNinjaApplication {

	public static void main(String[] args) {
		
		ApplicationContext context= SpringApplication.run(CodingNinjaApplication.class, args);
		
		System.out.println("Welcome to the coding ninjas Application");
		
		//IOC
//		AnnotationConfigApplicationContext context=
//				new AnnotationConfigApplicationContext("com.example.Codingninjaapplication");
		Scanner sc= new Scanner(System.in);
		
		//configure the course and create a list of courses offered.
		ArrayList<PaidCourse> paidCourses= new ArrayList<PaidCourse>();
		PaidCourse javaCourse= context.getBean(PaidCourse.class);
		javaCourse.setInstructor("java");
		PaidCourse springCourse= context.getBean(PaidCourse.class);
		springCourse.setInstructor("spring");
		
		//set java course instructor details and course name
		javaCourse.courseInstructor.setInstructorDetails("Rohan Singh", 26);
		javaCourse.setCourseDetail("Basics of Java");
		paidCourses.add(javaCourse);
		
		//set spring course instructor details and course name
		springCourse.courseInstructor.setInstructorDetails("Rahul mohan", 27);
		springCourse.setCourseDetail("SpringBoot and Spring");
		paidCourses.add(springCourse);
		
		while(true)
		{
			System.out.println("-----XXXXX-----");
			System.out.println("Please select from the following:");
			System.out.println("1. Register a new User \n2. See course Information \n3. To quit");
			int option= sc.nextInt();
			//to flush scanner
			sc.nextLine();
			switch(option)
			{
				case 1:
				{
					User user=context.getBean(User.class);
					System.out.println("Please enter your name:");
					String name=sc.nextLine();
					System.out.println("Plese enter you age:");
					String age= sc.nextLine();
					System.out.println("Plese enter you College:");
					String college= sc.nextLine();
					System.out.println("Plese enter you location:");
					String location= sc.nextLine();
					user.setUserDetails(name, age, location, college);
					
					int index=0;
					System.out.println("Please select a course");
					for(Course course: paidCourses)
					{
						System.out.println(index+") "+ course.getCourseName());
						index++;
					}
					int courseId=sc.nextInt();
					if(courseId>=paidCourses.size())
					{
						System.out.println("Invalid course");return;
					}
					PaidCourse selectedCourse= paidCourses.get(courseId);
					selectedCourse.userList.addUser(user);
					break;
				}
				case 2:
				{
//					display details of paid courses
					for(Course course: paidCourses)
					{
						System.out.println("-----XXXXX-----");
						System.out.println(course.getCourseName());
						if(course.getUserList().getUserList().size()>0)
						{
							System.out.println("The students in the course:");
							int index=1;
							for(User user :course.getUserList().getUserList())
							{
								System.out.println(index+") "+user.getUserDetails());
								index++;
							}
						}
						else
						{
							System.out.println("No students registered for the course");
						}
					}
					
					break;
				}
				case 3:
				{
					break;
				}
				default: System.out.println("Invalid choice");
			}
//			after switch
			if(option==3)
				break;
		}
		
		System.out.println("Program stopped");
		sc.close();
//		context.close();
		
	}

}
