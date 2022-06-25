package com.zack.staybooking.exception;

public class GCSUploadException extends RuntimeException{
    public GCSUploadException(String msg) {
        super(msg);
    }
}
