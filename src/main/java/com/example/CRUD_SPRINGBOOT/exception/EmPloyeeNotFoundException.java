package com.example.CRUD_SPRINGBOOT.exception;

public class EmPloyeeNotFoundException extends RuntimeException {
    public  EmPloyeeNotFoundException(Long id){
        super("Could not found the employee with id " + id);
    }
}
