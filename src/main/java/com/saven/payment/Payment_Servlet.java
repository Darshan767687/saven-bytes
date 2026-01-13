package com.saven.payment;

import java.io.IOException;

import com.saven.Services.OrderItem_Service;
import com.saven.model.OrderItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/payment")
public class Payment_Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		HttpSession session = req.getSession();
		int userId = (int) session.getAttribute("userId") ;
		int menuId =0;
		int total= (int ) session.getAttribute("totalAmount");
		
		OrderItem_Service item_Service = new OrderItem_Service();
		
		OrderItem order= new OrderItem();
		order.setOrderId(userId);
		order.setMenuId(menuId);
		order.setTotalamount(total);
		
		item_Service.addOrderItem(order);
		
		resp.sendRedirect("Thank.jsp");
		
	}

}
