package edu.homework;

import edu.compulsory.Document;
import edu.compulsory.Tags;
import edu.homework.commands.*;
import edu.homework.exceptions.InvalidFileException;
import edu.homework.exceptions.InvalidTemplateException;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InvalidTemplateException, InvalidFileException {
        List<Document> documents = new ArrayList<>();
        Map<Tags, Object> tags1 = new HashMap<>();
        tags1.put(Tags.TITLE, "Aircrew Quick Reference to the METAR and TAF Codes");
        tags1.put(Tags.YEAR, 2022);
        Document d1 = new Document("01D34", "Metar codes", "C:\\Users\\emmag\\Downloads\\METAR codes.pdf", tags1);
        Map<Tags, Object> tags2 = new HashMap<>();
        tags2.put(Tags.TITLE, "Cunoasterea Planorului");
        tags2.put(Tags.AUTHOR, "Dumitru Popovici");
        Document d2 = new Document("02D34", "Cunoasterea planorului", "C:\\Users\\emmag\\Downloads\\Cunoasterea Planorului Ed. 2009.pdf", tags2);
        edu.homework.Catalog catalog = new edu.homework.Catalog("Documente", documents);
        Command addD1 = new AddCommand(d1); addD1.run(catalog);
        //System.out.println(catalog);
        Command addD2 = new AddCommand(d2); addD2.run(catalog);
        //System.out.println(catalog);

        //catalog.save(catalog, "C:\\Users\\emmag\\OneDrive\\Desktop\\this.txt");
        Command list = new ListCommand();
        list.run(catalog);

        Command report = new ReportCommand();
        report.run(catalog);
        //Command openCatalog = new ViewCommand(new File(catalog.findById("02D34").getPath()));
        //openCatalog.run(catalog);
        //edu.compulsory.Catalog catalogGol = new Catalog();
        //catalogGol.load("C:\\Users\\emmag\\OneDrive\\Desktop\\this.txt");
        //System.out.println(catalogGol);
    }
}
