package com.zack.staybooking.exception;

public class InvalidStayAddrException extends RuntimeException{
    public InvalidStayAddrException(String msg) {
        super(msg);
    }
}
