package com.example.demo;

import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.InMemoryUserRepository;
import com.example.demo.repository.InMemoryAnswerRepository;
import com.example.demo.repository.InMemoryQuestionRepository;
import com.example.demo.service.QuestionService;
import com.example.demo.service.UserService;
import com.example.demo.service.AnswerService;
import com.example.demo.service.UserServiceImpl;
import com.example.demo.service.QuestionServiceImpl;
import com.example.demo.service.AnswerServiceImpl;

import java.util.Set;

import static com.example.demo.utils.Utils.displayQuestions;

public class Driver {

	public static void main(String[] args) {
		UserRepository userRepository = new InMemoryUserRepository();
		QuestionRepository questionRepository = new InMemoryQuestionRepository();
		AnswerRepository answerRepository = new InMemoryAnswerRepository();
		UserService userService = new UserServiceImpl(userRepository);
		QuestionService questionService = new QuestionServiceImpl(questionRepository, userService);
		AnswerService answerService = new AnswerServiceImpl(questionRepository, answerRepository, userService);

		userService.signUp("Sachin", "Developer");
		userService.signUp("Rajat", "Web Developer");
//		userService.signUp(null, "Developer");
		userService.login("Sachin");
		userService.subscribe("java", "hadoop", "jdk");
		questionService.addQuestion("What are new open source jdks?", "java", "jdk");
		questionService.addQuestion("Does Hadoop work on JDK 11?", "hadoop", "jdk");
//		questionService.addQuestion(null, "hadoop", "jdk");
		answerService.answerQuestion("Does Hadoop work on JDK 11?",
				"Apache Hadoop 3.3 and later versions support Java 11 for runtime only, " +
						"but compiling Hadoop with Java 11 is not supported.");
		answerService.upvoteQuestion("What are new open source jdks?");
		answerService.upvoteAnswer("Does Hadoop work on JDK 11?",
				"Apache Hadoop 3.3 and later versions support Java 11 for runtime only, " +
						"but compiling Hadoop with Java 11 is not supported.");
		answerService.upvoteQuestion("Does Hadoop work on JDK 17?");
		displayQuestions(questionService.getQuestions());
		displayQuestions(questionService.getQuestionsFilteredByTopics(Set.of("java")));
		displayQuestions(questionService.getQuestionsFilteredByTopics(Set.of("jdk")));
		displayQuestions(questionService.getAnsweredQuestions(true));
		userService.logout();
		displayQuestions(questionService.getQuestions());
		userService.login("Sachin");
		answerService.upvoteQuestion("Does Hadoop work on JDK 11?");
		answerService.upvoteQuestion("Does Hadoop work on JDK 11?");
		answerService.upvoteQuestion("Does Hadoop work on JDK 11?");
		answerService.upvoteQuestion("Does Hadoop work on JDK 11?");
		answerService.upvoteQuestion("Does Hadoop work on JDK 11?");
		displayQuestions(questionService.getQuestions());
		userService.logout();
		userService.login("Rajat");
		userService.signUp("Rajat", "Designer");
		userService.login("Rajat");
		questionService.addQuestion("What is the best tool to design a logo?");
		userService.logout();
		userService.login("Sachin");
		userService.logout();
	}

}
