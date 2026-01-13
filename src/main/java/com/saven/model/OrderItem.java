package com.saven.model;

public class OrderItem 
{
	private int orderItemId;
	private int orderId;
	private int menuId;
	private int totalamount;
	
	
	public OrderItem() {
	}


	public OrderItem(int orderItemId, int orderId, int menuId, int totalamount) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.totalamount = totalamount;
	}


	public int getOrderItemId() {
		return orderItemId;
	}


	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getTotalamount() {
		return totalamount;
	}


	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}


	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", menuId=" + menuId
				+ ", totalamount=" + totalamount + "]";
	}
	
	





}
