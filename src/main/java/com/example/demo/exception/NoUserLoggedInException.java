package com.example.demo.exception;

import static com.example.demo.constants.Constants.ERROR;

public class NoUserLoggedInException extends NullPointerException{
    public NoUserLoggedInException(String message) {
        System.out.println(ERROR + message);
        System.out.println();
    }
}
