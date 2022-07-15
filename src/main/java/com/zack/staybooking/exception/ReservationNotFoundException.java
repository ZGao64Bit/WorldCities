package com.zack.staybooking.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String msg) {
        super(msg);
    }
}
