package com.example.demo.exception;

import static com.example.demo.constants.Constants.ERROR;

public class AnswerNotFoundException extends NullPointerException{
    public AnswerNotFoundException(String message) {
        System.out.println(ERROR + message);
        System.out.println();
    }
}
