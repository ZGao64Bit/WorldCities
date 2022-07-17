package com.zack.staybooking.exceptions;

public class InvalidReservationDateException extends RuntimeException {
    public InvalidReservationDateException(String msg) {
        super(msg);
    }
}
