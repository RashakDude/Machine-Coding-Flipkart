package com.example.demo.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private String profession;
    private Set<String> subscribedTopics;
    private boolean isLoggedIn;

    public User(String name, String profession) {
        this.name = name;
        this.profession = profession;
        this.subscribedTopics = new HashSet<>();
        this.isLoggedIn = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Set<String> getSubscribedTopics() {
        return subscribedTopics;
    }

    public void setSubscribedTopics(Set<String> subscribedTopics) {
        this.subscribedTopics = subscribedTopics;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void subscribe(String... topics) {
        subscribedTopics.addAll(Arrays.asList(topics));
    }

    public void unsubscribe(String topic) {
        subscribedTopics.remove(topic);
    }
}
