package com.ecotech.usmt.exception;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException()
    {
        super("Resource not found on server");
    }
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}

