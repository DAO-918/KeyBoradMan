package com.kp.exception;

public class NoFoundAtricleException extends RuntimeException {

    public NoFoundAtricleException(String message) {
        super(message);
    }

    public NoFoundAtricleException(String message, Throwable cause) {
        super(message, cause);
    }

}