package com.example.computerhardwarestore.exceptions;

public class GoodAlreadyExistsException extends ComputerStoreException{
    public GoodAlreadyExistsException() {
    }

    public GoodAlreadyExistsException(String message) {
        super(message);
    }

    public GoodAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public GoodAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
