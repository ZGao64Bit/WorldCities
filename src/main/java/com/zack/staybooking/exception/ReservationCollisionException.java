package com.zack.staybooking.exception;

public class ReservationCollisionException extends RuntimeException {
    public ReservationCollisionException(String msg) {
        super(msg);
    }
}
