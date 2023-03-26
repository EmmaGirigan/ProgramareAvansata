package edu.compulsory;

import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;
    private String name;
    private String path;
    private Map<Tags, Object> tags = new HashMap<>();

    public Document(){};
    public Document(String id, String name, String path, Map<Tags, Object> tags) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.tags = tags;
    }

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<Tags, Object> getTags() {
        return tags;
    }

    public void setTags(Map<Tags, Object> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Document " + id + " {" +
                "name ='" + name + '\'' +
                ", path ='" + path + '\'' +
                ", tags =" + tags +
                '}';
    }
}
