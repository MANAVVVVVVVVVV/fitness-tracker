package com.fitlogix.model;

import java.util.*;

public class User {
    String id = UUID.randomUUID().toString().substring(0, 8);
    String name;
    int age;
    List<Workout> workouts = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addWorkout(Workout w) {
        workouts.add(w);
    }

    public String toString() {
        return "[" + id + "] " + name + " | Age: " + age + " | Total Workouts: " + workouts.size();
    }
}
