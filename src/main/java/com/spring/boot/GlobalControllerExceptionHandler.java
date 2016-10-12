package com.spring.boot;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;

/**
 * Created by vitaliy on 13.10.16.
 */
@ControllerAdvice
class GlobalControllerExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public void handle404Error() {
        System.out.println("Opsssssssssss!!!");
    }
}
