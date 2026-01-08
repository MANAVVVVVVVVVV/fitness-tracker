package com.fitlogix.model;

import java.time.LocalDate;
import java.util.UUID;

public class Workout {
private String id = UUID.randomUUID().toString().substring(0, 8);
private String type;
private int duration;
private String date = LocalDate.now().toString();

    public Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date + " → " + type + " → " + duration + " mins";
    }
}
