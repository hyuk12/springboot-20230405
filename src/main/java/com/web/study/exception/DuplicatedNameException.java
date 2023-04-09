package com.web.study.exception;

public class DuplicatedNameException extends RuntimeException {
    public DuplicatedNameException(String message) {
        super(message);
    }
}
