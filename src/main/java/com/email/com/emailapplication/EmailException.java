package com.email.com.emailapplication;

public class EmailException extends Exception{
    private String message;

    public EmailException(String message) {
        super(message);
    }
}
