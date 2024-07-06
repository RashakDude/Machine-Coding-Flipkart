package com.example.demo.service;

public interface AnswerService {
    void answerQuestion(String questionText, String answerText);
    void upvoteQuestion(String questionText);
    void upvoteAnswer(String questionText, String answerText);
}
