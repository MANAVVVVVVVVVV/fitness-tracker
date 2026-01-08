package com.fitlogix.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fitlogix.model.Workout;

public class User {
private String id = UUID.randomUUID().toString().substring(0, 8);
private String name;
private int age;
private List<Workout> workouts = new ArrayList<>();
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addWorkout(Workout w) {
        workouts.add(w);
    }

    public String getId() {
        return id;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public String toString() {
        return "[" + id + "] " + name + " | Age: " + age + " | Total Workouts: " + workouts.size();
    }
public String getName() {
    return name;
}

public int getAge() {
    return age;
}
}
