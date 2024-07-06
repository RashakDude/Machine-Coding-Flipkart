package com.example.demo.exception;

import static com.example.demo.constants.Constants.ERROR;

public class UserNotFoundException extends NullPointerException{
    public UserNotFoundException(String message){
        System.out.println(ERROR + message);
        System.out.println();
    }
}
