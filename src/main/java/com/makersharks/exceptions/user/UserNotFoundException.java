package com.makersharks.exceptions.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not found with the entered username!");
    }
}
