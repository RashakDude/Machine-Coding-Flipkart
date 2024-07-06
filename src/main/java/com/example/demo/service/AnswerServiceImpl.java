package com.example.demo.service;

import com.example.demo.exception.AnswerNotFoundException;
import com.example.demo.exception.NoUserLoggedInException;
import com.example.demo.exception.QuestionNotFoundException;
import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;

import java.util.Collections;

import static com.example.demo.constants.Constants.*;

public class AnswerServiceImpl implements AnswerService{
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserService userService;

    public AnswerServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository,
                             UserService userService) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userService = userService;
    }

    @Override
    public void answerQuestion(String questionText, String answerText) {
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser != null) {
            for (Question question : questionRepository.getAllQuestions()) {
                if (question.getText().equals(questionText) &&
                        !Collections.disjoint(loggedInUser.getSubscribedTopics(), question.getTopics())) {
                    Answer answer = new Answer(answerText, loggedInUser);
                    answerRepository.addAnswer(question, answer);
                    System.out.println(ANSWER_ADDED + answerText);
                    System.out.println();
                    return;
                }
            }
            new QuestionNotFoundException(QUESTION_NOT_FOUND);
        } else {
            new NoUserLoggedInException(NO_USER_LOGGED_IN);
        }
    }

    @Override
    public void upvoteQuestion(String questionText) {
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser != null) {
            for (Question question : questionRepository.getAllQuestions()) {
                if (question.getText().equals(questionText) &&
                        !Collections.disjoint(loggedInUser.getSubscribedTopics(), question.getTopics())) {
                    question.upvote();
                    System.out.println(QUESTION_UPVOTED + questionText);
                    System.out.println();
                    return;
                }
            }
            new QuestionNotFoundException(QUESTION_NOT_FOUND);
        } else {
            new NoUserLoggedInException(NO_USER_LOGGED_IN);
        }
    }

    @Override
    public void upvoteAnswer(String questionText, String answerText) {
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser != null) {
            for (Question question : questionRepository.getAllQuestions()) {
                if (question.getText().equals(questionText) &&
                        !Collections.disjoint(loggedInUser.getSubscribedTopics(), question.getTopics())) {
                    for (Answer answer : question.getAnswers()) {
                        if (answer.text.equals(answerText)) {
                            answer.upvote();
                            System.out.println(ANSWER_UPVOTED + answerText);
                            System.out.println();
                            return;
                        }
                    }
                }
            }
            new AnswerNotFoundException(ANSWER_NOT_FOUND);
        } else {
            new NoUserLoggedInException(NO_USER_LOGGED_IN);
        }
    }
}
