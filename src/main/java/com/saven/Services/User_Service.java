package com.saven.Services;

import com.saven.DAOImpl.User_impl;
import com.saven.model.User;

public class User_Service {
	

	public static void addUser(User user)
	{
			User_impl user_impl=new User_impl();
			user_impl.addUser(user);
	}
	
	public static User getUser(String username)
	{
		
		User_impl impl= new User_impl();
		User user=impl.getUser(username);
		return user;
		
	}
	
	public  static void update_user()
	{
		
		
		
	}
	
	public  static void delete_user()
	{
		
	}
	
	public  static void allUser()
	{
//		User_impl impl= new User_impl();
//		List<User> list =impl.getAll();
//		
//		for(int i=0;i<list.size();i++)
//		{
//			System.out.println(list.get(i));
//		}
//		
	}
	
	
}
