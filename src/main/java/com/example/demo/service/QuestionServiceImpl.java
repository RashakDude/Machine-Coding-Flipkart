package com.example.demo.service;

import com.example.demo.exception.NoUserLoggedInException;
import com.example.demo.exception.NotSubscribedException;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import com.example.demo.repository.QuestionRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo.constants.Constants.*;

public class QuestionServiceImpl implements QuestionService{
    private final QuestionRepository questionRepository;
    private final UserService userService;

    public QuestionServiceImpl(QuestionRepository questionRepository, UserService userService) {
        this.questionRepository = questionRepository;
        this.userService = userService;
    }

    @Override
    public void addQuestion(String text, String... topics) {
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser != null) {
            if (topics != null && topics.length > 0) {
                Question question = new Question(text, loggedInUser, Arrays.asList(topics));
                questionRepository.addQuestion(question);
                System.out.println(QUESTION_ADDED + text);
                System.out.println();
            } else {
                new NotSubscribedException(NOT_SUBSCIRBED_TO_TOPIC);
            }
        } else {
            new NoUserLoggedInException(NO_USER_LOGGED_IN);
        }
    }

    @Override
    public List<Question> getQuestions() {
        return questionRepository.getAllQuestions();
    }

    @Override
    public List<Question> getQuestionsFilteredByTopics(Set<String> topics) {
        return questionRepository.getAllQuestions().stream()
                .filter(question -> !Collections.disjoint(topics, question.getTopics()))
                .sorted((q1, q2) -> q2.getVotes() - q1.getVotes())
                .collect(Collectors.toList());
    }

    @Override
    public List<Question> getAnsweredQuestions(boolean answered) {
        return questionRepository.getAllQuestions().stream()
                .filter(question -> (answered && !question.getAnswers().isEmpty())
                        || (!answered && question.getAnswers().isEmpty()))
                .sorted((q1, q2) -> q2.getVotes() - q1.getVotes())
                .collect(Collectors.toList());
    }

}
