package org.example.tp_blog.exception;

public class ConstraintViolationException extends RuntimeException {

    public ConstraintViolationException(String message){
        super(message);
    }
}
