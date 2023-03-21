package edu.compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.compulsory.exceptions.InvalidCatalogException;

import java.io.File;
import java.io.IOException;

public class External{
    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }
    public static void load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
    }
}
