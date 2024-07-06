package com.example.demo.utils;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;

import java.util.List;

public class Utils {
    public static void displayQuestions(List<Question> questions) {
        for (Question question : questions) {
            System.out.println("Question: " + question.getText() + " | Topics: " +
                    question.getTopics() + " | Votes: " + question.getVotes());
            for (Answer answer : question.getAnswers()) {
                System.out.println("  Answer: " + answer.text + " | Votes: " + answer.votes);
            }
        }
        System.out.println();
    }
}
