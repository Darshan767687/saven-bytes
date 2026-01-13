package com.saven.cart_Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.saven.Services.Order_service;
import com.saven.model.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class Cart_Servlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession  session =req.getSession();
		Integer userIdObj = (Integer) session.getAttribute("userId");
		if (userIdObj == null) {
			resp.sendRedirect("index.html?reason=expired");

		    return;
		}
		int userId = userIdObj;

		String action = req.getParameter("action");
		int menu= Integer.parseInt(req.getParameter("menuId"));		
		
		
		
		List<Order> list= (List<Order>)session.getAttribute("list");
		
		if("add".equalsIgnoreCase(action))
		{
			for(Order li : list)
			{
				if(li.getMenuId() == menu)
				{
					li.setQuantity(li.getQuantity()+1);
					Order order= new Order();
					order.setUserId(li.getUserId());
					order.setMenuId(li.getMenuId());
					order.setQuantity(li.getQuantity());
					Order_service service= new Order_service();
					service.updateCart(order,li.getQuantity());
					break;
				}
			}
		}
		else if("remove".equalsIgnoreCase(action))
		{
			for(Order li : list)
			{
				if(li.getMenuId() == menu)
				{
					li.setQuantity(li.getQuantity()-1);
					Order order= new Order();
					order.setUserId(li.getUserId());
					order.setMenuId(li.getMenuId());
					order.setQuantity(li.getQuantity());
					Order_service service= new Order_service();
					service.updateOrder1(order,li.getQuantity());
					if(li.getQuantity()==0)
					{
						list.remove(li);
					}
					break;
				}
			}
		}else
		{
			int menuId = Integer.parseInt(req.getParameter("menuId"));
	        int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
	        String itemName = req.getParameter("itemName");
	        int price = Integer.parseInt(req.getParameter("price"));
			
		
		
		if(list == null)
		{
			list= new ArrayList<Order>();
		}
		
		Order order = new Order();
		order.setUserId(userId);
		order.setMenuId(menuId);
		order.setRestaurantId(restaurantId);
		order.setItemName(itemName);
		order.setPrice(price);
		order.setQuantity(1);
		
		boolean item=false;
		
		for(Order li : list)
		{
			if(li.getMenuId() == menuId)
			{
				li.setQuantity(li.getQuantity()+1);
				Order order1= new Order();
				order1.setUserId(li.getUserId());
				order1.setMenuId(li.getMenuId());
				order1.setQuantity(li.getQuantity());
				Order_service service= new Order_service();
				service.updateCart(order1,li.getQuantity());
				item=true;
				break;
			}
		}
		
		if(!item)
		{
			list.add(order);
			Order_service service= new Order_service();
			service.addToCart(order);
		}
		
		}

		session.setAttribute("list", list);

        resp.setStatus(HttpServletResponse.SC_OK);
	
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		HttpSession  session =req.getSession();
		Integer userIdObj = (Integer) session.getAttribute("userId");
		if (userIdObj == null) {
			resp.sendRedirect("index.html?reason=login");

		    return;
		}
		List<Order> li= (List<Order>) session.getAttribute("list");
		
		resp.sendRedirect("checkcart.jsp");
		
	}
	

}
