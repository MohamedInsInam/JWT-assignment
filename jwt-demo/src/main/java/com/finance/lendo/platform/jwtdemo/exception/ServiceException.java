package com.finance.lendo.platform.jwtdemo.exception;

public class ServiceException extends Exception {
    private String message;
    private String statusCode;

    public ServiceException(String message, String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

}
