package com.proiectpibd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class ErrorHandlingController {


    @ExceptionHandler(value = Exception.class)
    public String error404(){
        return "error/404";
    }
}
