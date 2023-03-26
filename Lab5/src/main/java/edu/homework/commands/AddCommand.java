package edu.homework.commands;

import edu.compulsory.Document;
import edu.homework.Catalog;

public class AddCommand implements Command{
    public AddCommand(Document document){
        this.document = document;
    }
    Document document = new Document();
    @Override
    public void run(Catalog catalog) {
        catalog.getDocuments().add(document);
    }
}
