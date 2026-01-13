package com.saven.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saven.connection.ConnectionClass;
import com.saven.dao.Order_DAO;
import com.saven.model.Order;

public class Order_impl implements Order_DAO {

	private static Connection connection= ConnectionClass.getConnection();
	
	public static void addToCart( Order order) 
	{
		String query= "Insert into `order` (`userId`, `restaurantId`, `menuId`, "
				+ "`price`, `itemName`,`quantity` ) values( ? , ?, ?, ? , ?, ? )";
		

				PreparedStatement preparedStatement;
				try {
					preparedStatement = connection.prepareStatement(query);
				
				
				preparedStatement.setInt(1, order.getUserId());
				preparedStatement.setInt(2, order.getRestaurantId());
				preparedStatement.setInt(3, order.getMenuId());
				preparedStatement.setInt(4, order.getPrice());
				preparedStatement.setString(5, order.getItemName());
				preparedStatement.setInt(6, order.getQuantity());
				
				preparedStatement.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			
		
	}
	
	public static List<Order> getCartItem(int userId)
	{
		String query="Select * from order where userId = ? ";
		List<Order> list= new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				Order order = new Order();
				order.setOrderId(resultSet.getInt(1));
				order.setUserId(resultSet.getInt(2));
				order.setRestaurantId(resultSet.getInt(3));
				order.setMenuId(resultSet.getInt(4));
				order.setPrice(resultSet.getInt(5));
				order.setItemName(resultSet.getString(6));
				order.setQuantity(resultSet.getInt(7));
				list.add(order);
			}
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public void updateOrder(Order order, int n) {
		String query =
			    "UPDATE `order` SET quantity = quantity + ? WHERE userId = ? AND menuId = ?";
			
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, n);
				preparedStatement.setInt(2, order.getUserId());
				preparedStatement.setInt(3, order.getMenuId());
				
				preparedStatement.execute();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void updateOrder1(Order order, int n) {
		String query =
				"UPDATE `order` SET quantity = quantity - ? WHERE userId = ? AND menuId = ?";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, n);
			preparedStatement.setInt(2, order.getUserId());
			preparedStatement.setInt(3, order.getMenuId());
			
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrder(List<Order> order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
