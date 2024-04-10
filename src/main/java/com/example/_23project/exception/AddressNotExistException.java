package com.example._23project.exception;

import org.apache.logging.log4j.message.Message;

public class AddressNotExistException extends RuntimeException {
    public AddressNotExistException(String message) {
        super(message);
    }
}
