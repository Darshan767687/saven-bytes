package com.saven.dao;

import java.util.List;

import com.saven.model.User;

public interface USER_DAO {
	
	public void addUser(User user);
	public User getUser(String username);	
	public void updateUser(int id, User user, String choice );
	public void deleteUser(int id);
	public List<User> getAll();

}
