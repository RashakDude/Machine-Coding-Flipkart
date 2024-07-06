package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    void signUp(String name, String profession);
    void login(String name);
    void logout();
    void subscribe(String... topics);
    User getLoggedInUser();
}
