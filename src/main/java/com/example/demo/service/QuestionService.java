package com.example.demo.service;

import com.example.demo.model.Question;

import java.util.List;
import java.util.Set;

public interface QuestionService {
    void addQuestion(String text, String... topics);
    List<Question> getQuestions();
    List<Question> getQuestionsFilteredByTopics(Set<String> topics);
    List<Question> getAnsweredQuestions(boolean answered);
}
