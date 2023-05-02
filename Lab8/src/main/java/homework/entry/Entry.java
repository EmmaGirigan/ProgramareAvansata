package homework.entry;

public abstract class Entry {

    private int id;
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entry(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Entry(String name){
        this.name = name;
    }
}
