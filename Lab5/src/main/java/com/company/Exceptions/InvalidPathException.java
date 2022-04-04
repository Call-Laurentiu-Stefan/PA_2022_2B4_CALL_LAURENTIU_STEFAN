package com.company.Exceptions;

public class InvalidPathException extends Exception{
    public InvalidPathException(Exception ex){
        super("Invalid path.", ex);
    }
}
