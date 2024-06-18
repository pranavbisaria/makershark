package com.makersharks.exceptions;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
