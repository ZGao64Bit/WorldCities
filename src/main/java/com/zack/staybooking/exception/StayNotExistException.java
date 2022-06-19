package com.zack.staybooking.exception;

public class StayNotExistException extends RuntimeException {
    public StayNotExistException(String msg) {
        super(msg);
    }
}
