package edu.homework;

public class Town extends Location{
    private int population;

    public Town(int population) {
        this.population = population;
    }

    public Town(String name, double x, double y, int population) {
        super(name, x, y);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
