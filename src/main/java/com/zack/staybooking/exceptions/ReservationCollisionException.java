package com.zack.staybooking.exceptions;

public class ReservationCollisionException extends RuntimeException {
    public ReservationCollisionException(String msg) {
        super(msg);
    }
}
