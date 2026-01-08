package com.fitlogix.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import com.fitlogix.dao.jdbc.DBConnection;
import com.fitlogix.dao.jdbc.WorkoutDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewWorkouts")
public class ViewWorkoutServlet extends HttpServlet {

    private final WorkoutDAO workoutDAO = new WorkoutDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userId = req.getParameter("userId");
        resp.setContentType("text/html");

        if (userId == null || userId.isBlank()) {
            resp.getWriter().println("User ID required ❌");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = workoutDAO.findByUser(userId, con);

            resp.getWriter().println("<h3>Workouts</h3>");
            boolean found = false;

            while (rs.next()) {
                found = true;
                resp.getWriter().println(
                    rs.getDate("date") + " → " +
                    rs.getString("type") + " → " +
                    rs.getInt("duration") + " mins<br>"
                );
            }

            if (!found) {
                resp.getWriter().println("No workouts found ❌");
            }

        } catch (Exception e) {
            resp.getWriter().println("Error fetching workouts ❌");
        }
    }
}
