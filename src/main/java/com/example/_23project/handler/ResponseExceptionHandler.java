package com.example._23project.handler;


import com.example._23project.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AddressAlreadyExistException.class)
    public ResponseEntity<ErrorExtension> handleAddressAlreadyExistException(Exception e){
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.CONFLICT).getErrorCode());
    }

    @ExceptionHandler(BuildingAlreadyExistException.class)
    public ResponseEntity<ErrorExtension> handleBuildingAlreadyExistException(Exception e){
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.CONFLICT).getErrorCode());
    }

    @ExceptionHandler(OwnerAlreadyExistException.class)
    public ResponseEntity<ErrorExtension> handleOwnerAlreadyExistException(Exception e){
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.CONFLICT).getErrorCode());
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ErrorExtension> handleUserAlreadyExistException(Exception e){
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.CONFLICT).getErrorCode());
    }

    @ExceptionHandler(AddressNotExistException.class)
    public ResponseEntity<ErrorExtension> handleAddressNotExistException(Exception e){
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.NOT_FOUND).getErrorCode());
    }

    @ExceptionHandler(BuildingNotExistException.class)
    public ResponseEntity<ErrorExtension> handleBuildingNotExistException(Exception e){
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.NOT_FOUND).getErrorCode());
    }

    @ExceptionHandler(OwnerNotExistException.class)
    public ResponseEntity<ErrorExtension> handleOwnerNotExistException(Exception e){
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.NOT_FOUND).getErrorCode());
    }

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<ErrorExtension> handleUserNotExistException(Exception e){
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.NOT_FOUND).getErrorCode());
    }
}
