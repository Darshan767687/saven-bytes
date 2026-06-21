package com.saven.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saven.connection.ConnectionClass;
import com.saven.dao.Restaurant_DAO;
import com.saven.model.Restaurant;

public class Restaurant_impl implements Restaurant_DAO {

    @Override
    public void addRestaurant(Restaurant restaurant) {
        Connection connection = ConnectionClass.getConnection();

        String query = "INSERT INTO restaurant " +
                "(name, username, password, cuisineType, deliveryTime, address, rating, isActive, imagePath) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, restaurant.getName());
            ps.setString(2, restaurant.getUsername());
            ps.setString(3, restaurant.getPassword());
            ps.setString(4, restaurant.getCuisineType());
            ps.setString(5, restaurant.getDeliveryTime());
            ps.setString(6, restaurant.getAddress());
            ps.setInt(7, restaurant.getRating());
            ps.setString(8, restaurant.getIsActive());

            String img = restaurant.getImagePath();
            if (img == null || img.trim().isEmpty()) {
                img = "https://images.unsplash.com/photo-1504674900247-0877df9cc836";
            }
            ps.setString(9, img);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Restaurant> getAllRestaurant() {

        List<Restaurant> list = new ArrayList<>();

        Connection connection = ConnectionClass.getConnection();
        String query = "SELECT * FROM restaurant";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Restaurant restaurant = new Restaurant();

                restaurant.setRestaurantId(rs.getInt(1));
                restaurant.setName(rs.getString(2));
                restaurant.setUsername(rs.getString(3));
                restaurant.setPassword(rs.getString(4));
                restaurant.setCuisineType(rs.getString(5));
                restaurant.setDeliveryTime(rs.getString(6));
                restaurant.setAddress(rs.getString(7));
                restaurant.setRating(rs.getInt(8));
                restaurant.setIsActive(rs.getString(9));

                String img = rs.getString(10);
                if (img == null || img.trim().isEmpty()) {
                    img = "https://images.unsplash.com/photo-1504674900247-0877df9cc836";
                }

                restaurant.setImagePath(img);

                list.add(restaurant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) {

        Restaurant restaurant = new Restaurant();

        Connection connection = ConnectionClass.getConnection();
        String query = "SELECT * FROM restaurant WHERE restaurantId = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                restaurant.setRestaurantId(rs.getInt(1));
                restaurant.setName(rs.getString(2));
                restaurant.setUsername(rs.getString(3));
                restaurant.setPassword(rs.getString(4));
                restaurant.setCuisineType(rs.getString(5));
                restaurant.setDeliveryTime(rs.getString(6));
                restaurant.setAddress(rs.getString(7));
                restaurant.setRating(rs.getInt(8));
                restaurant.setIsActive(rs.getString(9));

                String img = rs.getString(10);
                if (img == null || img.trim().isEmpty()) {
                    img = "https://images.unsplash.com/photo-1504674900247-0877df9cc836";
                }

                restaurant.setImagePath(img);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurant;
    }

    // باقي methods untouched (safe)
    @Override
    public Restaurant getRestaurant(String username) {
        return new Restaurant();
    }

    @Override
    public void updateRestaurant(String username, Restaurant restaurant, String choice) {
    }

    @Override
    public void deleteRestaurant(String username) {
    }
}