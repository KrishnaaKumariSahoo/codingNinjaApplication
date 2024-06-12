package com.example.Codingninjaapplication;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SimpleUserList implements UserList{
	
	ArrayList<User> listOfUsers;
	
	public SimpleUserList(){
		this.listOfUsers= new ArrayList<User>();
	}
	@Override
	public ArrayList<User> getUserList() {
		return this.listOfUsers;
	}

	@Override
	public void addUser(User user) {
		this.listOfUsers.add(user);
	}

}
