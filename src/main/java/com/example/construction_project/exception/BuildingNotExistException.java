package com.example.construction_project.exception;

public class BuildingNotExistException extends RuntimeException{
    public BuildingNotExistException(String message) {
        super(message);
    }
}
