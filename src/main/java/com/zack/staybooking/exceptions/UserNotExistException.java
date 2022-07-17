package com.zack.staybooking.exceptions;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(String msg) {
        super(msg);
    }
}
