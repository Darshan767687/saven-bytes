package com.saven.user_Login_servlets;

import java.io.IOException;

import com.saven.Services.User_Service;
import com.saven.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class User_Login_Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        System.out.println("🔥 REGISTER API HIT - VERSION 2.0.1");

        User user = User_Service.getUser(username);

        if (user != null && user.getPassword() != null) {

            if (user.getPassword().equals(password)) {

                HttpSession session = req.getSession();
                session.setAttribute("userId", user.getUserId());
                session.setAttribute("username", user.getUsername());

                resp.sendRedirect("restdisp");

            } else {
                resp.sendRedirect("index.html?reason=wrongpassword");
            }

        } else {
            resp.sendRedirect("index.html?reason=nouser");
        }
    }
}