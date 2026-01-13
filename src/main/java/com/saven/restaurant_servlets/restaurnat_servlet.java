package com.saven.restaurant_servlets;

import java.io.IOException;
import java.util.List;

import com.saven.Services.Restaurant_Service;
import com.saven.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class restaurnat_servlet extends HttpServlet
{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession  session =req.getSession();
		Integer userIdObj = (Integer) session.getAttribute("userId");
		if (userIdObj == null) {
			resp.sendRedirect("index.html?reason=expired");

		    return;
		}
		int userId = userIdObj;
		Restaurant_Service restaurant_Service= new Restaurant_Service();
		List<Restaurant>  restaurants = restaurant_Service.getAllRestaurant();
		req.setAttribute("restaurants", restaurants);
        req.getRequestDispatcher("restaurants.jsp").forward(req, resp);

	
	
	}
	

}
