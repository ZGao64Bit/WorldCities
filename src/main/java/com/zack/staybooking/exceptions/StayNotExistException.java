package com.zack.staybooking.exceptions;

public class StayNotExistException extends RuntimeException {
    public StayNotExistException(String msg) {
        super(msg);
    }
}
