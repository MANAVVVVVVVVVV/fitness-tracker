package com.fitlogix.dao.jdbc;

import com.fitlogix.model.Workout;
import java.sql.*;

public class WorkoutDAO {

    public boolean save(String userId, Workout w) {
        String sql = "INSERT INTO workouts (id, user_id, type, duration, date) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, w.getId());
            ps.setString(2, userId);
            ps.setString(3, w.getType());
            ps.setInt(4, w.getDuration());
            ps.setDate(5, Date.valueOf(w.getDate()));

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException("Error saving workout", e);
        }
    }

    public ResultSet findByUser(String userId, Connection con) throws SQLException {
        String sql = "SELECT * FROM workouts WHERE user_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, userId);
        return ps.executeQuery();
    }
}