package com.zack.staybooking.exception;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(String msg) {
        super(msg);
    }
}
