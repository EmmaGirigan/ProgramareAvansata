package edu.homework;

import java.util.Objects;
import edu.homework.Problem;

public abstract class Location {
    private String name;
    private double x;
    private double y;

    public Location(){}

    public Location(String name, double x, double y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Location)) return false;
        Location location = (Location) o;
        return Double.compare(location.getX(), getX()) == 0 && Double.compare(location.getY(), getY()) == 0 && getName().equals(location.getName());
    }

}
