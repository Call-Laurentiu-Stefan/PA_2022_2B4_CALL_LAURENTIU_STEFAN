package com.company.Exceptions;

public class InvalidCommandException extends Exception{
    public InvalidCommandException(Exception ex){
        super("Invalid command.", ex);
    }
}
