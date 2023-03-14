package edu.compulsory;

public class Project implements Comparable<Project>{
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Project project) {
        return this.name.compareTo(project.name);
    }
}
