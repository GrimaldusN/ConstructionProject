package com.example._23project.exception;

public class OwnerAlreadyExistException extends RuntimeException {
    public OwnerAlreadyExistException(String message) {
        super(message);
    }
}
