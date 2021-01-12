package com.proiectpibd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingController {


    @ExceptionHandler(value = Exception.class)
    public String error404(){
        return "error/404";
    }

    @ExceptionHandler(value = Error.class)
    public String error500() {
        return "error/500";
    }
}
