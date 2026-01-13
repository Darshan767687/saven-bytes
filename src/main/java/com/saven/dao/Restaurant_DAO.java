package com.saven.dao;

import java.util.List;

import com.saven.model.Restaurant;

public interface Restaurant_DAO 
{
	public void addRestaurant(Restaurant restaurant);
	public Restaurant getRestaurant(String username);
	public Restaurant getRestaurantById(int restaurantId);
	public void updateRestaurant(String username,Restaurant restaurant, String choice);
	public void deleteRestaurant(String username);
	public List<Restaurant> getAllRestaurant();

}
