package com.example._23project.exception;

public class BuildingAlreadyExistException extends RuntimeException{
    public BuildingAlreadyExistException(String message) {
        super(message);
    }
}
