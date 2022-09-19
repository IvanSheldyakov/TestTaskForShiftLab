package com.example.computerhardwarestore.controller.advice;

import com.example.computerhardwarestore.exceptions.ComputerStoreException;
import com.example.computerhardwarestore.model.ResponseMessage;
import com.example.computerhardwarestore.utility.Regex;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@ControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(ComputerStoreException.class)
    public ResponseEntity<ResponseMessage> handleException(ComputerStoreException e) {
        ResponseMessage response = new ResponseMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseMessage> handleException(HttpMessageNotReadableException e) {
        String message = findPossibleValues(e.getMessage());
        ResponseMessage response = new ResponseMessage(message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private String findPossibleValues(String message) {

        Pattern pattern = Pattern.compile(Regex.SOMETHING_BETWEEN_SQUARE_BRACKETS);
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            return "incorrect value, use values " + message.substring(matcher.start(), matcher.end());
        } else {
            return message;
        }
    }
}
