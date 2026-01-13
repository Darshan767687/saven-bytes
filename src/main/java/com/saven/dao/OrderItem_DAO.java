package com.saven.dao;


import java.util.List;

import com.saven.model.OrderItem;

public interface OrderItem_DAO {
	
	public void addOrderItem (OrderItem  orderItem);
	public OrderItem  getOrderItem (int id);
	public void updateOrderItem (OrderItem  orderItem);
	public void deleteOrderItem (int id);
	public List<OrderItem > getAllOrderItem ();


}
