package org.example.tp_blog.controller;

import org.example.tp_blog.exception.ConstraintViolationException;
import org.example.tp_blog.exception.FormException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.awt.*;

@ControllerAdvice
public class ExceptionRestController {


    @ResponseBody
    @ExceptionHandler(FormException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String formException(FormException e) {
        return "Il y a un problème lors de la saisie du formulaire " + e.getMessage() ;
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String constraintViolationException(ConstraintViolationException e) {
        return "Il y a un problème lors de la saisie du formulaire " + e.getMessage() ;
    }
}
