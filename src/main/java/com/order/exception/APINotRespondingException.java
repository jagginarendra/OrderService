package com.order.exception;

public class APINotRespondingException extends RuntimeException {

    public APINotRespondingException(String message) {
        super(message);
    }
}
