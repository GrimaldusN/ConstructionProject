package com.example.construction_project.exception;

public class BuildingAlreadyExistException extends RuntimeException{
    public BuildingAlreadyExistException(String message) {
        super(message);
    }
}
