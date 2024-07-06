package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private String text;
    private User user;
    private List<String> topics;
    private LocalDateTime timestamp;
    private List<Answer> answers;
    private int votes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public Question(String text, User user, List<String> topics) {
        this.text = text;
        this.user = user;
        this.topics = topics;
        this.timestamp = LocalDateTime.now();
        this.answers = new ArrayList<>();
        this.votes = 0;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void upvote() {
        votes++;
    }
}
