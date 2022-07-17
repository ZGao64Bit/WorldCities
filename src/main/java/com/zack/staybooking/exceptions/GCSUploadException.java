package com.zack.staybooking.exceptions;

public class GCSUploadException extends RuntimeException{
    public GCSUploadException(String msg) {
        super(msg);
    }
}
