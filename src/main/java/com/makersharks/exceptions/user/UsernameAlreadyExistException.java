package com.makersharks.exceptions.user;

public class UsernameAlreadyExistException extends RuntimeException {
    public UsernameAlreadyExistException() {
        super("A user with this username already exists");
    }
}
