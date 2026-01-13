package com.saven.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saven.connection.ConnectionClass;
import com.saven.dao.Menu_DAO;
import com.saven.model.Menu;

public class Menu_impl implements Menu_DAO {
	
	private Connection connection= ConnectionClass.getConnection();

	@Override
	public void addMenu(Menu menu, int  restaurantId) 
	{
		String query= "Inser into ` menu` (`restaurantId`,`itemName`,"
				+ "`description`,`price`,`isAvailable`,`imagePath`)"
				+ "values( ? , ? , ? , ? , ? , ? )";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, restaurantId);
			preparedStatement.setString(2, menu.getItemName());
			preparedStatement.setString(3,menu.getDescription());
			preparedStatement.setInt(4, menu.getPrice());
			preparedStatement.setString(5,menu.getIsAvailable());
			preparedStatement.setString(6, menu.getImagePath());
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public Menu getMenu(int id) {
		
		String query="Select * from menu Where menuId= ? ";
		Menu menu= new Menu();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				menu.setMenuId(resultSet.getInt(1));
				menu.setRestaurantId(resultSet.getInt(2));
				menu.setItemName(resultSet.getString(3));
				menu.setDescription(resultSet.getString(4));
				menu.setPrice(resultSet.getInt(5));
				menu.setIsAvailable(resultSet.getString(6));
				menu.setImagePath(resultSet.getString(7));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;

		

	}

	@Override
	public void updateMenu(Menu menu) {

		
	}

	@Override
	public void deleteMenu(int id) {

		
	}

	@Override
	public List<Menu> getAllMenu(int restaurantId) {
		String query="Select * from menu where restaurantId= ? ";
		List<Menu> list= new ArrayList<Menu>();
		try {
			PreparedStatement stmt= connection.prepareStatement(query);
			stmt.setInt(1, restaurantId);
			ResultSet resultSet= stmt.executeQuery();
			while(resultSet.next())
			{
				Menu menu= new Menu();
				menu.setMenuId(resultSet.getInt(1));
				menu.setRestaurantId(resultSet.getInt(2));
				menu.setItemName(resultSet.getString(3));
				menu.setDescription(resultSet.getString(4));
				menu.setPrice(resultSet.getInt(5));
				menu.setIsAvailable(resultSet.getString(6));
				menu.setImagePath(resultSet.getString(7));
				list.add(menu);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		

	}

}
