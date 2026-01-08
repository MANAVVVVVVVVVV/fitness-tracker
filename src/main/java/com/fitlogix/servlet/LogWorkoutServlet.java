package com.fitlogix.servlet;

import java.io.IOException;

import com.fitlogix.service.FitnessService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logWorkout")
public class LogWorkoutServlet extends HttpServlet {

    private FitnessService service;

    @Override
public void init() {
    service = new FitnessService(new com.fitlogix.dao.DataStore());
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String type = req.getParameter("type");
        String durationStr = req.getParameter("duration");

        try {
            int duration = Integer.parseInt(durationStr);

            boolean success = service.logWorkoutDB(userId, type, duration);

            if (success) {
                resp.sendRedirect("index.html");
            } else {
                resp.getWriter().println("Invalid workout data ❌");
            }

        } catch (Exception e) {
            resp.getWriter().println("Error logging workout ❌");
        }
    }
}
