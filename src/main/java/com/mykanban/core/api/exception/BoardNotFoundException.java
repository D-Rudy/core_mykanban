package com.mykanban.core.api.exception;

public class BoardNotFoundException extends Exception {

    public BoardNotFoundException(String message) {
        super(message);
    }
}
