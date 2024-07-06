package com.example.demo.exception;

import static com.example.demo.constants.Constants.ERROR;

public class NotSubscribedException extends NullPointerException{
    public NotSubscribedException(String message) {
        System.out.println(ERROR + message);
        System.out.println();
    }
}
