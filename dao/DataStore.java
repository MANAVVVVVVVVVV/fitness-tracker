package com.fitlogix.dao;

import com.fitlogix.model.*;
import com.google.gson.*;
import java.io.*;
import java.util.*;

public class DataStore {
    private final String FILE = "data.json";
    private List<User> users = new ArrayList<>();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public DataStore() {
        load();
    }

    public void addUser(User u) {
        users.add(u);
        save();
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> findUser(String id) {
        return users.stream().filter(u -> u.id.equals(id)).findFirst();
    }

    public void save() {
        try (Writer w = new FileWriter(FILE)) {
            gson.toJson(users, w);
        } catch (Exception e) {
        }
    }

    public void load() {
        try {
            Reader r = new FileReader(FILE);
            User[] arr = gson.fromJson(r, User[].class);
            if (arr != null)
                users = new ArrayList<>(Arrays.asList(arr));
        } catch (Exception e) {
        }
    }
}
