package com.company.Exceptions;

    public class InvalidTypeException extends Exception{
        public InvalidTypeException(Exception ex){
            super("Invalid type.", ex);
        }
    }

