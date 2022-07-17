package com.zack.staybooking.exceptions;

public class InvalidStayAddressException extends RuntimeException{
    public InvalidStayAddressException(String msg) {
        super(msg);
    }
}
