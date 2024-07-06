package com.example.demo.repository;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;

public class InMemoryAnswerRepository implements AnswerRepository{
    @Override
    public void addAnswer(Question question, Answer answer) {
        question.addAnswer(answer);
    }
}
