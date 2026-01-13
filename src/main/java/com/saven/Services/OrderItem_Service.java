package com.saven.Services;

import java.util.List;

import com.saven.DAOImpl.OrderItem_impl;
import com.saven.model.OrderItem;

public class OrderItem_Service {
	
	public void addOrderItem(OrderItem orderItem)
	{
		OrderItem_impl impl= new OrderItem_impl();
		impl.addOrderItem(orderItem);
	}
	
	public List<OrderItem> getAllOrderItem()
	{
		OrderItem_impl impl= new OrderItem_impl();
		return impl.getAllOrderItem();
		
		
	}

}
