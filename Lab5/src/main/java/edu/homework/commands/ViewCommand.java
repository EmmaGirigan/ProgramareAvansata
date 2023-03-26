package edu.homework.commands;
import edu.homework.Catalog;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command{
    public ViewCommand(File file){
        this.file = file;
    }
    private File file;
    @Override
    public void run(Catalog catalog) {
        Desktop view = Desktop.getDesktop();
        try {
            view.open(file);
        }catch (IOException e){
            System.err.println("File does not exist");
            return;
        }
        finally {
        }
    }
}
