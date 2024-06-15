package com.example.construction_project.exception;

public class AddressAlreadyExistException extends RuntimeException{
    public AddressAlreadyExistException(String message) {
        super(message);
    }
}
