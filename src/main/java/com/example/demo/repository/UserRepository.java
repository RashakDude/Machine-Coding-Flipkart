package com.example.demo.repository;

import com.example.demo.model.User;

public interface UserRepository {
    void addUser(User user);
    User getUser(String name);
}
