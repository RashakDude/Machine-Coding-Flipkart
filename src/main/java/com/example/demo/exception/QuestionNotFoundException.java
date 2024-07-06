package com.example.demo.exception;

import static com.example.demo.constants.Constants.ERROR;

public class QuestionNotFoundException extends NullPointerException{
    public QuestionNotFoundException(String message) {
        System.out.println(ERROR + message);
        System.out.println();
    }
}
