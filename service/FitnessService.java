package com.fitlogix.service;

import com.fitlogix.dao.*;
import com.fitlogix.model.*;
import java.util.*;

public class FitnessService {
    private final DataStore ds;

    public FitnessService(DataStore ds) {
        this.ds = ds;
    }

    public User createUser(String name, int age) {
        User u = new User(name, age);
        ds.addUser(u);
        return u;
    }

    public boolean logWorkout(String id, String type, int mins) {
        Optional<User> ou = ds.findUser(shortId);
        if (ou.isPresent()) {
            ou.get().addWorkout(new Workout(type, mins));
            ds.save();
            return true;
        }
        return false;
    }
}
