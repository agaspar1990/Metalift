package com.nice.exception;

public class MissingMandatoryElementException extends Exception {
    public MissingMandatoryElementException(String message) {
        super(message);
    }
}
