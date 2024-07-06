package com.example.demo.exception;

import static com.example.demo.constants.Constants.ERROR;

public class AnotherUserLoggedInException extends RuntimeException{
    public AnotherUserLoggedInException(String message) {
        System.out.println(ERROR + message);
        System.out.println();
    }
}
