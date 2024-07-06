package com.example.demo.service;

import com.example.demo.exception.AnotherUserLoggedInException;
import com.example.demo.exception.NoUserLoggedInException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.Arrays;

import static com.example.demo.constants.Constants.*;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private User loggedInUser;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(String name, String profession) {
        User user = new User(name, profession);
        userRepository.addUser(user);
        System.out.println(name + SIGNED_UP_AS + profession);
        System.out.println();
    }

    @Override
    public void login(String name) {
        if (loggedInUser != null) {
            new AnotherUserLoggedInException(ANOTHER_USER_LOGGED_IN);
        }
        User user = userRepository.getUser(name);
        if (user != null) {
            user.setLoggedIn(true);
            loggedInUser = user;
            System.out.println(name + LOGGED_IN);
            System.out.println();
        } else {
            new UserNotFoundException(USER_NOT_FOUND);
        }
    }

    @Override
    public void logout() {
        if (loggedInUser != null) {
            loggedInUser.setLoggedIn(false);
            System.out.println(loggedInUser.getName() + LOGGED_OUT);
            System.out.println();
            loggedInUser = null;
        } else {
            new NoUserLoggedInException(NO_USER_LOGGED_IN);
        }
    }

    @Override
    public void subscribe(String... topics) {
        if (loggedInUser != null) {
            loggedInUser.subscribe(topics);
            System.out.println(loggedInUser.getName() + SUBSCRIBED_TO + Arrays.toString(topics));
            System.out.println();
        } else {
            new NoUserLoggedInException(NO_USER_LOGGED_IN);
        }
    }

    @Override
    public User getLoggedInUser() {
        return loggedInUser;
    }
}
