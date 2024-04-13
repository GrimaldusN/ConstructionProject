package com.example._23project.exception;

public class BuildingNotExistException extends RuntimeException{
    public BuildingNotExistException(String message) {
        super(message);
    }
}
