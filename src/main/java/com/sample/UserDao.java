package com.sample;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
	ArrayList<User> userList = new ArrayList<User>();
	
	public ArrayList<User> getAllUsers(){
		userList.add(new User(1, "Mahesh", "Teacher"));
		userList.add(new User(2, "Jhonatan", "Student"));
         return userList;
	}
	
	public User getUser(int id){
		userList = getAllUsers();
		for (User user:userList){
			if (user.getId() == id)
			{
				return user;
			}
		}
		return null;
	}
	
	public int addUser(User user, ArrayList<User> users){
		if (users.add(user))
		{
			return 1;
		}else
		{
			return 0;
		}
	}
	
	public int deleteUser(int userId, ArrayList<User> users){
		for(User user:users){
			if (user.getId() == userId)
			{
				//Se averigua indice del objeto actual
				userList.remove(users.indexOf(user));
				//Tambien se podria:
					//userList.remove(user);
				return 1;
			}
		}
		return 0;
	}
	
	public ArrayList<User> updateUser(User updateUser, ArrayList<User> users){
		for (User user:users){
			if (user.getId() == updateUser.getId())
			{
				int index = userList.indexOf(user);
				userList.set(index, updateUser);
				return users;
			}
		}
		return users;
	}
	

      
}