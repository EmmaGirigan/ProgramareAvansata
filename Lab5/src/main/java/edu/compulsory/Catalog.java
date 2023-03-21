package edu.compulsory;

import java.util.*;

public class Catalog {
    private String name;
    private List<Document> documents = new ArrayList<>();

    public Catalog(String name, List<Document> documents) {
        this.name = name;
        this.documents = documents;
    }

    void add(Document document){
        this.documents.add(document);
    }

    public Document findById(String id) {
        return documents.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("Catalog ").append(name).append("{\n");
        for(Document document : documents) {
            System.out.println(document.toString());
            toString.append(document.toString());
        }
        return toString.toString();
    }
}
