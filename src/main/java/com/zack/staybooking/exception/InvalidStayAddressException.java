package com.zack.staybooking.exception;

public class InvalidStayAddressException extends RuntimeException{
    public InvalidStayAddressException(String msg) {
        super(msg);
    }
}
