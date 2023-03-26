package edu.homework.exceptions;

public class InvalidTemplateException extends Exception{
    public InvalidTemplateException() {
        super("Template is not valid");
    }
}
