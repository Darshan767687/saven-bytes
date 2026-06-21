package com.saven.user_Login_servlets;

import java.io.IOException;

import com.saven.Services.User_Service;
import com.saven.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class User_Register_Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String role = "Customer";

        long phone;
        try {
            phone = Long.parseLong(req.getParameter("phone"));
        } catch (Exception e) {
            resp.sendRedirect("Registration.html?error=invalid_phone");
            return;
        }

        User_Service service = new User_Service();

        // 🔥 SAFE CHECK (NO NULL CRASH EVER)
        User existingUser = service.getUser(username);

        if (existingUser == null) {

            User newUser = new User(username, password, email, phone, address, role);
            service.addUser(newUser);

            resp.sendRedirect("index.html?success=registered");

        } else {
            resp.sendRedirect("Registration.html?error=username_taken");
        }
    }
}