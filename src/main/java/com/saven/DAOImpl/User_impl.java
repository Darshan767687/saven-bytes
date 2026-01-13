package com.saven.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saven.connection.ConnectionClass;
import com.saven.dao.USER_DAO;
import com.saven.model.User;

public class User_impl implements USER_DAO {

	 

	@Override
	public void addUser(User user) {
		 Connection connection= ConnectionClass.getConnection();

		String query="INSERT into `user` (`username`,`password`,`email`,`phone`,`address`,`role`)"
				+ "values( ? , ? , ? , ? , ? , ? ) ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setLong(4, user.getPhone());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setString(6, user.getRole());
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 


	}

	@Override
	public User getUser(String username) {
		 Connection connection= ConnectionClass.getConnection();

		
		User user= new User();
		String query= "SELECT * from user WHERE `username`= ? ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			ResultSet resultSet= preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user.setUserId(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setEmail(resultSet.getString(4));
				user.setPhone(resultSet.getLong(5));
				user.setAddress(resultSet.getString(6));
				user.setRole(resultSet.getString(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public void updateUser(int id, User user, String choice) {
		
		 Connection connection= ConnectionClass.getConnection();

		String query1="UPDATE `user` SET `username` = ?  WHERE `userId`  = ? ";
		String query2="UPDATE `user` SET `password` = ?  WHERE `userId`  = ? ";
		String query3="UPDATE `user` SET `email` = ?  WHERE `userId`  = ? ";
		String query4="UPDATE `user` SET `phone` = ?  WHERE `userId`  = ? ";
		String query5="UPDATE `user` SET `address` = ?  WHERE `userId`  = ? ";
		PreparedStatement preparedStatement = null;
		
		try
		{
			
			if(choice.equalsIgnoreCase("name"))
			{
				preparedStatement = connection.prepareStatement(query1);
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setInt(2, id);
			}
			else if(choice.equalsIgnoreCase("password"))
			{
				preparedStatement = connection.prepareStatement(query2);	
				preparedStatement.setString(1, user.getPassword());
				preparedStatement.setInt(2, id);
			}
			else if(choice.equalsIgnoreCase("email"))
			{
				preparedStatement = connection.prepareStatement(query3);	
				preparedStatement.setString(1, user.getEmail());
				preparedStatement.setInt(2, id);
			}
			else if(choice.equalsIgnoreCase("phone"))
			{
				preparedStatement = connection.prepareStatement(query4);	
				preparedStatement.setLong(1, user.getPhone());
				preparedStatement.setInt(2, id);
			}
			else if(choice.equalsIgnoreCase("address"))
			{
				preparedStatement = connection.prepareStatement(query5);	
				preparedStatement.setString(1, user.getAddress());
				preparedStatement.setInt(2, id);
			}
			
			preparedStatement.execute();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(int id) {
		 Connection connection= ConnectionClass.getConnection();

		String query="Delete from `user` where userId= ? ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public List<User> getAll() {
		 Connection connection= ConnectionClass.getConnection();

		
		String query=  "SELECT * FROM `user`";
		List<User> list= new ArrayList<User>();
		
		try {
			Statement statement= connection.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			
			while(resultSet.next())
			{
				User user= new User();
				user.setUserId(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setEmail(resultSet.getString(4));
				user.setPhone(resultSet.getLong(5));
				user.setAddress(resultSet.getString(6));
				user.setRole(resultSet.getString(7));
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
