package com.zack.staybooking.exception;

public class InvalidReservationDateException extends RuntimeException {
    public InvalidReservationDateException(String msg) {
        super(msg);
    }
}
