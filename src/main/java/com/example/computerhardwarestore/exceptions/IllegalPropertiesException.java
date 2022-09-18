package com.example.computerhardwarestore.exceptions;

public class IllegalPropertiesException extends ComputerStoreException{
    public IllegalPropertiesException() {
    }

    public IllegalPropertiesException(String message) {
        super(message);
    }

    public IllegalPropertiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalPropertiesException(Throwable cause) {
        super(cause);
    }

    public IllegalPropertiesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
