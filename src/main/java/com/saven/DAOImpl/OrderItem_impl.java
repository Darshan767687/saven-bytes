package com.saven.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saven.connection.ConnectionClass;
import com.saven.dao.OrderItem_DAO;
import com.saven.model.OrderItem;

public class OrderItem_impl implements OrderItem_DAO {
	private static Connection connection = ConnectionClass.getConnection();

	@Override
	public void addOrderItem(OrderItem orderItem) {
		
		String query="Insert INTO `orderItem`("
				+ " `orderId`, `menuId`, `totalamount`) values( ? , ? , ? )";
		
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(query);
			
			preparedStatement.setInt(1, orderItem.getOrderId());
			preparedStatement.setInt(2, orderItem.getMenuId());
			preparedStatement.setInt(3, orderItem.getTotalamount());
			
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public OrderItem getOrderItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderItem(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderItem> getAllOrderItem() {
		
		String query= "Select * from `orderitem` ";
		List<OrderItem> list = new ArrayList<>();
		try {
			Statement statement= connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next())
			{
				OrderItem orderItem = new OrderItem();
				orderItem.setOrderItemId(resultSet.getInt(1));
				orderItem.setOrderId(resultSet.getInt(2));
				orderItem.setMenuId(resultSet.getInt(3));
				orderItem.setTotalamount(resultSet.getInt(4));
				list.add(orderItem);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
