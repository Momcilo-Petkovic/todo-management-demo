package com.momcilocode.todo_management.exception;

import org.springframework.http.HttpStatus;

public class TodoAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public TodoAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
