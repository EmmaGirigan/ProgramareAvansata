package edu.compulsory;

import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;
    private String name;
    private Map<String, String> tags = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
