package com.saven.user_Login_servlets;
import java.io.IOException;
import java.io.PrintWriter;

import com.mysql.cj.Session;
import com.saven.Services.User_Service;
import com.saven.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class User_Login_Servlet extends HttpServlet {
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");

		

		
		User_Service user_Service= new User_Service();
		
		String username= req.getParameter("username");
		String password= req.getParameter("password");
		
		User user= User_Service.getUser(username);
		
		
		if(user.getPassword().equalsIgnoreCase(password))
		{
			HttpSession session = req.getSession();
			session.setAttribute("userId", user.getUserId());
			
			resp.sendRedirect("restdisp");
		}
		else 
		{
			resp.sendRedirect("index.html?reason=login");

		}
		
		
		
		
	}


}
