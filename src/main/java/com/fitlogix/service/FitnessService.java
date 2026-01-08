package com.fitlogix.service;

import com.fitlogix.dao.DataStore;
import com.fitlogix.dao.jdbc.UserDAO;
import com.fitlogix.dao.jdbc.WorkoutDAO;
import com.fitlogix.model.User;
import com.fitlogix.model.Workout;

import java.util.Optional;

public class FitnessService {

    // Review-1 (JSON based)
    private final DataStore ds;

    // Review-2 (JDBC based)
    private final UserDAO userDAO = new UserDAO();
    private final WorkoutDAO workoutDAO = new WorkoutDAO();

    public FitnessService(DataStore ds) {
        this.ds = ds;
    }

    // ================= REVIEW 1 =================
    public User createUser(String name, int age) {
        User u = new User(name, age);
        ds.addUser(u);
        return u;
    }

    public boolean logWorkout(String id, String type, int mins) {
        Optional<User> ou = ds.findUser(id);
        if (ou.isPresent()) {
            ou.get().addWorkout(new Workout(type, mins));
            ds.save();
            return true;
        }
        return false;
    }

    // ================= REVIEW 2 =================
    public boolean createUserDB(String name, int age) {
        if (name == null || name.isBlank() || age <= 0)
            return false;

        User u = new User(name, age);
        return userDAO.save(u);
    }

    public boolean logWorkoutDB(String userId, String type, int duration) {
        if (userId == null || type == null || type.isBlank() || duration <= 0)
            return false;

        Workout w = new Workout(type, duration);
        return workoutDAO.save(userId, w);
    }
}