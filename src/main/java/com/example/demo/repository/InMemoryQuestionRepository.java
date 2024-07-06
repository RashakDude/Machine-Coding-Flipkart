package com.example.demo.repository;

import com.example.demo.model.Question;

import java.util.ArrayList;
import java.util.List;

public class InMemoryQuestionRepository implements QuestionRepository{
    private final List<Question> questions = new ArrayList<>();

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questions;
    }
}
