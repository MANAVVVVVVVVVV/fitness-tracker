// @Deprecated – Console-only class, excluded from web build
package com.fitlogix.ui;

import com.fitlogix.model.User;
import com.fitlogix.model.Workout;
import com.fitlogix.service.*;
import com.fitlogix.dao.*;
import java.util.*;

@Deprecated
public class ConsoleUI {
    Scanner sc = new Scanner(System.in);
    FitnessService service;
    DataStore ds;

    public ConsoleUI(FitnessService s, DataStore d) {
        this.service = s;
        this.ds = d;
    }

    public void start() {
        while (true) {
            System.out.println("\n1. List Users");
            System.out.println("2. Create User");
            System.out.println("3. Log Workout");
            System.out.println("4. View Workouts");
            System.out.println("0. Exit");
            System.out.print("Choose → ");

            String c = sc.nextLine();
            if (c.equals("1"))
                list();
            if (c.equals("2"))
                create();
            if (c.equals("3"))
                log();
            if (c.equals("4"))
                view();
            if (c.equals("0"))
                break;
        }
    }

    void list() {
        ds.getUsers().forEach(System.out::println);
    }

    void create() {
        System.out.print("Name → ");
        String n = sc.nextLine();
        System.out.print("Age → ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println(service.createUser(n, a));
    }

    void log() {
        System.out.print("User ID → ");
        String id = sc.nextLine();
        System.out.print("Workout type → ");
        String t = sc.nextLine();
        System.out.print("Minutes → ");
        int m = Integer.parseInt(sc.nextLine());
        System.out.println(service.logWorkout(id, t, m) ? "Logged ✅" : "Not Found ❌");
    }

    void view() {
        System.out.print("User ID → ");
        String id = sc.nextLine();
        ds.findUser(id).ifPresentOrElse(
                u -> u.getWorkouts().forEach(System.out::println),
                () -> System.out.println("User not found ❌"));
    }
}
