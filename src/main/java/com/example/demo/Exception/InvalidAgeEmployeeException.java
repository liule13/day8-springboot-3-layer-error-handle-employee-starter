package com.example.demo.Exception;

public class InvalidAgeEmployeeException extends RuntimeException {
    public InvalidAgeEmployeeException(String message) {
        super(message);
    }
}
