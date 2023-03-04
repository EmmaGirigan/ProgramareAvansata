package edu.homework;

public class Airport extends Location{
    private int numberOfTerminals;

    public Airport(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }

    public Airport(String name, double x, double y, int numberOfTerminals) {
        super(name, x, y);
        this.numberOfTerminals = numberOfTerminals;
    }

    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }
}
