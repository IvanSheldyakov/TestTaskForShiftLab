package com.example.computerhardwarestore.exceptions;

public class ComputerStoreException extends RuntimeException{

    public ComputerStoreException() {
    }

    public ComputerStoreException(String message) {
        super(message);
    }

    public ComputerStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComputerStoreException(Throwable cause) {
        super(cause);
    }

    public ComputerStoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
