package com.fitlogix.model;

import java.time.*;
import java.util.*;

public class Workout {
    String id = UUID.randomUUID().toString().substring(0, 8);
    String type;
    int duration;
    String date = LocalDate.now().toString();

    public Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    public String toString() {
        return date + " → " + type + " → " + duration + " mins";
    }
}
