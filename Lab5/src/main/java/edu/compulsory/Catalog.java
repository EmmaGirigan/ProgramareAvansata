package edu.compulsory;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String name;
    private List<Document> documents = new ArrayList<>();

    void add(Document document){
        this.documents.add(document);
    }

    public Document findById(String id) {
        return documents.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
}
