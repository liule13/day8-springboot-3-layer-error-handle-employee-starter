package com.example.demo.advice;

import com.example.demo.Exception.EmployeeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseException handleException(Exception e) {
        return new ResponseException(e.getMessage());
    }
    @ExceptionHandler(EmployeeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseException handleEmployeeException(Exception e) {
        return new ResponseException(e.getMessage());
    }
}
