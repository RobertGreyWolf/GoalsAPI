package com.example.demo.Exceptions;
public class InvalidInput extends RuntimeException {
    public InvalidInput(String message) {
        super(message);
    }
}
