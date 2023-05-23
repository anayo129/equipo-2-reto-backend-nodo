package com.backend.retoequipo2.model.exceptions;

public class BusinessException extends Exception {

    public BusinessException(String message){
        super("Business rule exception: " + message);
    }
}
