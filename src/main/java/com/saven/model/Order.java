package com.saven.model;

import java.sql.Timestamp;

public class Order
{
	
	private int orderId;
	private int userId;
	private int restaurantId;
	private int menuId;
	private int price;
	private String itemName;
	private int quantity;
	
	


	public Order() {
		
	}
	
	


	public Order(int orderId, int userId, int restaurantId, int menuId, int price, String itemName, int quantity) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.menuId = menuId;
		this.price = price;
		this.itemName = itemName;
		this.quantity=quantity;
	}




	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}




	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", menuId="
				+ menuId + ", price=" + price + ", itemName=" + itemName + ", quantity=" + quantity + "]";
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	


}
