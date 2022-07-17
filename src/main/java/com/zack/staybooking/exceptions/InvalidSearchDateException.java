package com.zack.staybooking.exceptions;

public class InvalidSearchDateException extends RuntimeException{
    public InvalidSearchDateException(String message) {
        super(message);
    }
}
