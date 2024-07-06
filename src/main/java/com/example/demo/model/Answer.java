package com.example.demo.model;

import java.time.LocalDateTime;

public class Answer {
    public String text;
    private User user;
    private LocalDateTime timestamp;
    public int votes;

    public Answer(String text, User user) {
        this.text = text;
        this.user = user;
        this.timestamp = LocalDateTime.now();
        this.votes = 0;
    }

    public void upvote() {
        votes++;
    }
}
