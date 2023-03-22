package edu.compulsory;

import java.util.*;

public class Catalog extends External {
    private String name;
    private List<Document> documents = new ArrayList<>();

    public Catalog(){}
    public Catalog(String name, List<Document> documents) {
        this.name = name;
        this.documents = documents;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocuments(List<Document> documents) {
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
            toString.append(document.toString());
            toString.append("\n");
        }
        toString.append("}");
        return toString.toString();
    }
}
