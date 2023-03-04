package edu.homework;

import edu.compulsory.RoadType;

import java.util.Scanner;

public class Road {
    private RoadType type;
    private int length;
    private int speedLimit;
    private edu.homework.Location node1;
    private edu.homework.Location node2;

    public Road(){}

    public Road(RoadType type, int length, int speedLimit, Location node1, Location node2){
        this.type = type;
        this.node1 = node1; //nodurile pe care acest road le conecteaza trebuie specificate inainte de a specifica length
        this.node2 = node2;
        length = checkLength(length); //daca length este mai mica decat distanta euclidiana intre cele doua noduri mai sus specificate, ii atribui alta valoare
        this.length = length;
        this.speedLimit = speedLimit;
    }


    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        length = checkLength(length);
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Location getNode1() {
        return node1;
    }

    public void setNode1(edu.homework.Location node1) {
        this.node1 = node1;
    }

    public edu.homework.Location getNode2() {
        return node2;
    }

    public void setNode2(edu.homework.Location node2) {
        this.node2 = node2;
    }

    /**
     * Metoda foloseste formula de calcul pentru dintanta euclidiana intre doua puncte pe un sistem de axe
     * @param node1 Primul punct
     * @param node2 Al doilea punct
     * @return Distanta Euclidiana intre node1 si node2
     */
    public double getEuclidianDistance(Location node1, Location node2){
        return Math.sqrt((node2.getY() - node1.getY()) * (node2.getY() - node1.getY()) + (node2.getX() - node1.getX()) * (node2.getX() - node1.getX()));
    }

    /**
     * Metoda verifica daca length este mai mic decat distanta calculata anterior
     * Cat timp length este mai mic, i se va reatribui o valoare data de la
     * Altfel, valoarea length ramane aceeasi
     * @param length Lungimea data initial
     * @return Lungimea corespunzatoare
     */
    public int checkLength(int length){
        while(length < getEuclidianDistance(this.node1, this.node2)) {
            System.out.printf("Choose length greater than %f%n", getEuclidianDistance(this.node1, this.node2));
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Input length: %n");
            length = scanner.nextInt();
        }
        return length;
    }

    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                ", connects " + node1 +
                " to " + node2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road)) return false;
        Road road = (Road) o;
        return getLength() == road.getLength() && getSpeedLimit() == road.getSpeedLimit() && getType() == road.getType() && getNode1().equals(road.getNode1()) && getNode2().equals(road.getNode2());
    }

}
