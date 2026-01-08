package com.fitlogix.servlet;

import java.io.IOException;

import com.fitlogix.service.FitnessService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createUser")
public class CreateUserServlet extends HttpServlet {

    private FitnessService service;

    @Override
public void init() {
    service = new FitnessService(new com.fitlogix.dao.DataStore());
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String ageStr = req.getParameter("age");

        try {
            int age = Integer.parseInt(ageStr);

            boolean success = service.createUserDB(name, age);

            if (success) {
                resp.sendRedirect("index.html");
            } else {
                resp.getWriter().println("Invalid data ❌");
            }

        } catch (Exception e) {
            resp.getWriter().println("Error creating user ❌");
        }
    }
}
