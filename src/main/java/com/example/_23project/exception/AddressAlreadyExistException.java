package com.example._23project.exception;

public class AddressAlreadyExistException extends RuntimeException{
    public AddressAlreadyExistException(String message) {
        super(message);
    }
}
