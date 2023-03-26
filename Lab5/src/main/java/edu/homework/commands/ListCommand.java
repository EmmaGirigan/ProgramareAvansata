package edu.homework.commands;

import edu.homework.Catalog;

public class ListCommand implements Command{
    @Override
    public void run(Catalog catalog) {
        System.out.println(catalog.getDocuments());
    }
}
