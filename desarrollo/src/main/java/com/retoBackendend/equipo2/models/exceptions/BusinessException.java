package com.retoBackendend.equipo2.models.exceptions;

public class BusinessException extends Exception {

    public BusinessException(String message){
        super("Business rule exception: " + message);
    }
}
