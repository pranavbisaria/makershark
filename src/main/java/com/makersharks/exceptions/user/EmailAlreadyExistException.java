package com.makersharks.exceptions.user;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException() {
        super("A user with this email already exists");
    }
}
