package com.saven.menu_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.saven.Services.Menu_Service;
import com.saven.Services.Restaurant_Service;
import com.saven.model.Menu;
import com.saven.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Menu_List_Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		HttpSession  session =req.getSession();
		Integer userIdObj = (Integer) session.getAttribute("userId");
		if (userIdObj == null) {
			resp.sendRedirect("index.html?reason=expired");

		    return;
		}
		
		int rest_id= Integer.parseInt(req.getParameter("restaurantId"));
		
		Restaurant_Service rest= new Restaurant_Service();
		Restaurant restaurant = rest.getRestaurantById(rest_id);
		
		
		PrintWriter printWriter= resp.getWriter();
		Menu_Service menu_Service= new Menu_Service();
		List<Menu> li= menu_Service.getAllMenu(rest_id);
		
		 req.setAttribute("restaurant", restaurant);   // 🔥 this is your restaurant object
	        req.setAttribute("menuList", li);

	        // 5. Forward to menu.jsp
	        req.getRequestDispatcher("menu.jsp").forward(req, resp);
		
	
	}

}
