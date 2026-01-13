package com.saven.dao;

import java.util.List;

import com.saven.model.Order;

public interface Order_DAO {
	
	public void addOrder (List<Order> order);
	public Order  getOrder (int id);
	public void updateOrder (Order  order, int n);
	public void deleteOrder (int id);
	public List<Order > getAllOrder ();


}
