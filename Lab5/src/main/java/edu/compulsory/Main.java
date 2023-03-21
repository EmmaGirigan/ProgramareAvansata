package edu.compulsory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Document> documents = new ArrayList<>();
        Map<Tags, Object> tags1 = new HashMap<>();
        tags1.put(Tags.TITLE, "Aircrew Quick Reference to the METAR and TAF Codes");
        tags1.put(Tags.YEAR, 2022);
        Document d1 = new Document("01D34", "Metar codes", "\"C:\\Users\\emmag\\Downloads\\METAR codes.pdf\"", tags1);
        System.out.println(d1);
        Map<Tags, Object> tags2 = new HashMap<>();
        tags2.put(Tags.TITLE, "Cunoasterea Planorului");
        tags2.put(Tags.AUTHOR, "Dumitru Popovici");
        tags2.put(Tags.AUTHOR, "Mariana Popovici");
        Document d2 = new Document("02D34", "Cunoasterea planorului", "\"C:\\Users\\emmag\\Downloads\\Cunoasterea Planorului Ed. 2009.pdf\"", tags2);
        Catalog catalog = new Catalog("Documente", documents);
        System.out.println(catalog);
    }
}
