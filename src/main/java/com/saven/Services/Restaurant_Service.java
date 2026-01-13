package com.saven.Services;

import java.util.List;

import com.saven.DAOImpl.Restaurant_impl;
import com.saven.model.Restaurant;

public class Restaurant_Service {
	
	
	public Restaurant getRestaurantById(int restaurantId)
	{
		Restaurant_impl restaurant_impl= new  Restaurant_impl();
		return restaurant_impl.getRestaurantById(restaurantId);
	}
	
	
	public void addRestaurant(Restaurant restaurant)
	{
		Restaurant_impl restaurant_impl= new  Restaurant_impl();
		restaurant_impl.addRestaurant(restaurant);
	}
	
	public Restaurant getRestaurant(String username)
	{
		Restaurant_impl restaurant_impl= new  Restaurant_impl();
		return restaurant_impl.getRestaurant(username);
		
	}
	
	public void updateRestaurant(String username, Restaurant restaurant, String choice)
	{
		Restaurant_impl restaurant_impl= new  Restaurant_impl();
		restaurant_impl.updateRestaurant(username, restaurant, choice);
	}
	
	public void deleteRestaurant(String username)
	{
		Restaurant_impl restaurant_impl= new  Restaurant_impl();
		restaurant_impl.deleteRestaurant(username);
		
	}
	
	public   List<Restaurant> getAllRestaurant()
	{
		Restaurant_impl restaurant_impl= new  Restaurant_impl();
		return restaurant_impl.getAllRestaurant();
		
	}
	

}
