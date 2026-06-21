package com.saven.restaurant_servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.saven.Services.Restaurant_Service;
import com.saven.helper.sortByName;
import com.saven.helper.sortByRating;
import com.saven.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Restaurants_filter_servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        Integer userIdObj = (Integer) session.getAttribute("userId");

        if (userIdObj == null) {
            resp.sendRedirect("index.html?reason=expired");
            return;
        }

        // INPUTS (safe parsing)
        String cuisine = req.getParameter("cuisine");
        String sort = req.getParameter("sortBy");

        float rating = 0.0f;
        try {
            rating = Float.parseFloat(req.getParameter("minRating"));
        } catch (Exception e) {
            rating = 0.0f;
        }

        if (cuisine == null || cuisine.trim().isEmpty()) {
            cuisine = "any";
        }

        if (sort == null || sort.trim().isEmpty()) {
            sort = "rating_desc";
        }

        // DATA FETCH
        Restaurant_Service restaurant_Service = new Restaurant_Service();
        List<Restaurant> list = restaurant_Service.getAllRestaurant();

        List<Restaurant> rlist = new ArrayList<>();

        // FILTER LOGIC (CLEAN & FIXED)
        for (Restaurant r : list) {

            boolean cuisineMatch =
                    cuisine.equalsIgnoreCase("any") ||
                    r.getCuisineType().equalsIgnoreCase(cuisine);

            boolean ratingMatch =
                    rating == 0.0f ||
                    r.getRating() >= rating;

            if (cuisineMatch && ratingMatch) {
                rlist.add(r);
            }
        }

        // SORTING
        if (sort.equalsIgnoreCase("name_asc")) {
            Collections.sort(rlist, new sortByName());
        }

        else if (sort.equalsIgnoreCase("name_desc")) {
            Collections.sort(rlist, new sortByName());
            Collections.reverse(rlist);
        }

        else if (sort.equalsIgnoreCase("rating_asc")) {
            Collections.sort(rlist, new sortByRating());
        }

        else {
            Collections.sort(rlist, new sortByRating());
            Collections.reverse(rlist); // rating_desc default
        }

        // RESPONSE
        req.setAttribute("restaurants", rlist);
        req.getRequestDispatcher("restaurants.jsp").forward(req, resp);
    }
}