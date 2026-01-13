package com.saven.Services;

import java.util.List;

import com.saven.DAOImpl.Order_impl;
import com.saven.model.Order;

public class Order_service {
	
	
	public static void addToCart(Order order)
	{
		Order_impl order_impl = new Order_impl();
		order_impl.addToCart(order);
	}
	
	public List<Order> getCartItem(int userId)
	{
		Order_impl order_impl = new Order_impl();
		return order_impl.getCartItem(userId);	
	}
	
	public void updateCart(Order order, int n)
	{
		Order_impl order_impl = new Order_impl();
		 order_impl.updateOrder(order, n);	

	}
	public void updateOrder1(Order order, int n)
	{
		Order_impl order_impl = new Order_impl();
		order_impl.updateOrder1(order, n);	
		
	}

}
