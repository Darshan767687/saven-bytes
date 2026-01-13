package com.saven.user_Login_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.saven.Services.User_Service;
import com.saven.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class User_Register_Servlet extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter p= resp.getWriter();
		String username=req.getParameter("username");
		String password= req.getParameter("password");
		String email=req.getParameter("email");
		long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		String role="Customer";
		User user1=new User(username,password,email,phone,address,role);
		
		User_Service user_service= new User_Service();
		User user = user_service.getUser(username);
		
		if(user.getUsername() == null)
		{
			user_service.addUser(user1);
			resp.sendRedirect("index.html");	
		}
		else
		{
	        resp.sendRedirect("Registration.html?error=username_taken");

		}
	}

}
