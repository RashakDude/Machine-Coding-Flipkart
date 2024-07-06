package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository{
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public User getUser(String name) {
        return users.get(name);
    }
}
