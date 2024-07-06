package com.example.demo.repository;

import com.example.demo.model.Question;

import java.util.List;

public interface QuestionRepository {
    void addQuestion(Question question);
    List<Question> getAllQuestions();
}
