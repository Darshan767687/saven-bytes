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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession  session =req.getSession();
		Integer userIdObj = (Integer) session.getAttribute("userId");
		if (userIdObj == null) {
			resp.sendRedirect("index.html?reason=expired");

		    return;
		}
		String cuisine=req.getParameter("cuisine");
		Float rating= Float.parseFloat(req.getParameter("minRating"));
		String sort= req.getParameter("sortBy");
		if(cuisine.equals(""))
		{
			cuisine="any";
		}
		
		Restaurant_Service restaurant_Service= new Restaurant_Service();
		
		List<Restaurant > list = restaurant_Service.getAllRestaurant();
		
		List<Restaurant> rlist= new ArrayList<Restaurant>();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getCuisineType().equalsIgnoreCase(cuisine) && list.get(i).getRating()<=rating+0.5)
			{
				rlist.add(list.get(i));
			}
			else if(cuisine.equalsIgnoreCase("any") && list.get(i).getRating()<=rating+0.5 )
			{
				rlist.add(list.get(i));		
			}
			else if(rating==0.0 && list.get(i).getCuisineType().equalsIgnoreCase(cuisine) )
			{
				rlist.add(list.get(i));		
			}
			else if(cuisine.equalsIgnoreCase("any") && rating==0.0 )
			{
				rlist.add(list.get(i));	
			}
			
		}
		if(sort.equalsIgnoreCase("name_desc") || sort.equalsIgnoreCase("name_asc"))
		{
			Collections.sort(rlist, new sortByName());
			if(sort.equalsIgnoreCase("name_desc"))
			{
				List<Restaurant> rev_list=rlist.reversed();
				req.setAttribute("restaurants", rev_list);
				 req.getRequestDispatcher("restaurants.jsp").forward(req, resp);
			}
			else
			{

				req.setAttribute("restaurants", rlist);
				 req.getRequestDispatcher("restaurants.jsp").forward(req, resp);
			}
		}
		else 
		{
			Collections.sort(rlist, new sortByRating());
			
			if(sort.equalsIgnoreCase("rating_desc"))
			{
				List<Restaurant> rev_list=rlist.reversed();
				req.setAttribute("restaurants", rev_list);
				 req.getRequestDispatcher("restaurants.jsp").forward(req, resp);
				
			}
			else
			{
				req.setAttribute("restaurants", rlist);
				 req.getRequestDispatcher("restaurants.jsp").forward(req, resp);
			}
		}
		
		
		
	
	}

}
