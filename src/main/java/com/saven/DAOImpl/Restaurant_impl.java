package com.saven.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saven.connection.ConnectionClass;
import com.saven.dao.Restaurant_DAO;
import com.saven.model.Restaurant;

public class Restaurant_impl implements Restaurant_DAO {



	@Override
	public void addRestaurant(Restaurant restaurant) {
		Connection connection= ConnectionClass.getConnection();

		String query="Insert into `restaurant` (`name`,`username`,`password`,`cuisineType`,`deliveryTime`,`address`,`rating`,`isActive`,`imagePath`)"
				+ "values( ? , ? , ? , ? , ? , ? , ? , ? , ? ) ";
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(query);

			preparedStatement.setString(1, restaurant.getName());
			preparedStatement.setString(2, restaurant.getUsername());
			preparedStatement.setString(3, restaurant.getPassword());
			preparedStatement.setString(4, restaurant.getCuisineType());
			preparedStatement.setString(5, restaurant.getDeliveryTime());
			preparedStatement.setString(6, restaurant.getAddress());
			preparedStatement.setInt(7, restaurant.getRating());
			preparedStatement.setString(8, restaurant.getIsActive());
			preparedStatement.setString(9, restaurant.getImagePath());

			preparedStatement.execute();




		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public Restaurant getRestaurant(String username) {

		Restaurant restaurant = new Restaurant();

		Connection connection= ConnectionClass.getConnection();
		String query= " Select * from `restaurant` where `username`= ?  ";
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next())
			{
				restaurant.setName(resultset.getString(1));
				restaurant.setUsername(resultset.getString(2));
				restaurant.setPassword(resultset.getString(3));
				restaurant.setCuisineType(resultset.getString(4));
				restaurant.setDeliveryTime(resultset.getString(5));
				restaurant.setAddress(resultset.getString(6));
				restaurant.setRating(resultset.getInt(7));
				restaurant.setIsActive(resultset.getString(8));
				restaurant.setImagePath(resultset.getString(9));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return restaurant;
	}

	@Override
	public void updateRestaurant(String username ,Restaurant restaurant, String choice) {
		Connection connection= ConnectionClass.getConnection();
		PreparedStatement  preparedStatement = null;

		String query2="UPDATE `restaurant` SET `password` = ?  WHERE `username`  = ? ";

		String query3="UPDATE `restaurant` SET `cuisineType` = ?  WHERE `username`  = ? ";

		String query4="UPDATE `restaurant` SET `deliveryTime` = ?  WHERE `username`  = ? ";

		String query5="UPDATE `restaurant` SET `rating` = ?  WHERE `username`  = ? ";		

		String query6="UPDATE `restaurant` SET `name` = ?  WHERE `username`  = ? ";

		String query7="UPDATE `restaurant` SET `address` = ?  WHERE `username`  = ? ";		

		String query8="UPDATE `restaurant` SET `isActive` = ?  WHERE `username`  = ? ";		

		String query9="UPDATE `restaurant` SET `imagePath` = ?  WHERE `username`  = ? ";		

		if(choice.equalsIgnoreCase("name"))
		{
			try {
				connection.prepareStatement(query6);
				preparedStatement.setString(1, restaurant.getName());
				preparedStatement.setString(2, username);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		else if(choice.equalsIgnoreCase("password"))
		{
			try {
				connection.prepareStatement(query2);
				preparedStatement.setString(1, restaurant.getPassword());
				preparedStatement.setString(2, username);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		else if(choice.equalsIgnoreCase("deliveryTime"))
		{
			try {
				connection.prepareStatement(query4);
				preparedStatement.setString(1, restaurant.getDeliveryTime());
				preparedStatement.setString(2, username);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		else if(choice.equalsIgnoreCase("cuisineType"))
		{
			try {
				connection.prepareStatement(query3);
				preparedStatement.setString(1, restaurant.getCuisineType());
				preparedStatement.setString(2, username);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		else if(choice.equalsIgnoreCase("rating"))
		{
			try {
				connection.prepareStatement(query5);
				preparedStatement.setInt(1, restaurant.getRating());
				preparedStatement.setString(2, username);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		else if(choice.equalsIgnoreCase("address"))
		{
			try {
				connection.prepareStatement(query7);
				preparedStatement.setString(1, restaurant.getAddress());
				preparedStatement.setString(2, username);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		else if(choice.equalsIgnoreCase("isActive"))
		{
			try {
				connection.prepareStatement(query8);
				preparedStatement.setString(1, restaurant.getIsActive());
				preparedStatement.setString(2, username);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		else if(choice.equalsIgnoreCase("imagePath"))
		{
			try {
				connection.prepareStatement(query9);
				preparedStatement.setString(1, restaurant.getImagePath());
				preparedStatement.setString(2, username);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void deleteRestaurant(String username) {
		Connection connection= ConnectionClass.getConnection();

		String query="Delete from `restaurant` where username= ? ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}



	}

	@Override
	public List<Restaurant> getAllRestaurant() {

		List<Restaurant> list = new ArrayList<Restaurant>();

		Connection connection= ConnectionClass.getConnection();
		String query= "Select * from `restaurant` ";
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				Restaurant restaurant  = new Restaurant();

				restaurant.setRestaurantId(resultSet.getInt(1));
				restaurant.setName(resultSet.getString(2));
				restaurant.setUsername(resultSet.getString(3));
				restaurant.setPassword(resultSet.getString(4));
				restaurant.setCuisineType(resultSet.getString(5));
				restaurant.setDeliveryTime(resultSet.getString(6));
				restaurant.setAddress(resultSet.getString(7));
				restaurant.setRating(resultSet.getInt(8));
				restaurant.setIsActive(resultSet.getString(9));
				restaurant.setImagePath(resultSet.getString(10));
				list.add(restaurant);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId) {
		Restaurant restaurant = new Restaurant();

		Connection connection= ConnectionClass.getConnection();
		String query= " Select * from `restaurant` where `restaurantId`= ?  ";
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(query);
			preparedStatement.setInt(1, restaurantId);
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next())
			{
				restaurant.setRestaurantId(resultset.getInt(1));
				restaurant.setName(resultset.getString(2));
				restaurant.setUsername(resultset.getString(3));
				restaurant.setPassword(resultset.getString(4));
				restaurant.setCuisineType(resultset.getString(5));
				restaurant.setDeliveryTime(resultset.getString(6));
				restaurant.setAddress(resultset.getString(7));
				restaurant.setRating(resultset.getInt(8));
				restaurant.setIsActive(resultset.getString(9));
				restaurant.setImagePath(resultset.getString(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurant;
	}

}
