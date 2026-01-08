package com.fitlogix.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fitlogix.model.User;

public class UserDAO {

    public boolean save(User user) {
        String sql = "INSERT INTO users (id, name, age) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setInt(3, user.getAge());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}