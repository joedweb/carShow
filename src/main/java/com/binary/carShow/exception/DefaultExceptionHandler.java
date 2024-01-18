package com.binary.carShow.exception;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice       //"when the error happens. it will advise the controller what tp show the user
public class DefaultExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleException(ResourceNotFoundException e, HttpServletRequest request){
                                                                                    //^user info
        ApiError apiError = new ApiError(
                request.getRequestURI(),        //String path
                e.getMessage(),                 //String message
                HttpStatus.NOT_FOUND.value(),   //int statusCode
                LocalDateTime.now()             //LDT timestamp
        );
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}
