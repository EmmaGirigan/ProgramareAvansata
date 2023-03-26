package edu.homework.commands;

import edu.homework.Catalog;
import edu.homework.exceptions.InvalidFileException;
import edu.homework.exceptions.InvalidTemplateException;

public interface Command {
    void run(Catalog catalog) throws InvalidTemplateException, InvalidFileException;
}
