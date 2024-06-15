package com.example.construction_project.exception;

public class OwnerAlreadyExistException extends RuntimeException {
    public OwnerAlreadyExistException(String message) {
        super(message);
    }
}
