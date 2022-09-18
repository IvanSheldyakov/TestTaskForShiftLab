package com.example.computerhardwarestore.controller.advice;


import com.example.computerhardwarestore.exceptions.EntityNotFoundException;
import com.example.computerhardwarestore.exceptions.JsonProcessingException;
import com.example.computerhardwarestore.model.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseMessage> handleException(EntityNotFoundException e) {
        ResponseMessage response = new ResponseMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<ResponseMessage> handleException(JsonProcessingException e) {
        ResponseMessage response = new ResponseMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
