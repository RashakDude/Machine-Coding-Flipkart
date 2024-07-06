package com.example.demo.repository;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;

public interface AnswerRepository {
    void addAnswer(Question question, Answer answer);
}
