package edu.homework.exceptions;

public class InvalidFileException extends Exception {
    public InvalidFileException(){
        super("File or directory is not valid");
    }
}
