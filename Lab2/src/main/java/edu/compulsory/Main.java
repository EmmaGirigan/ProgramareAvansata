package edu.compulsory;

import edu.compulsory.Location;
import edu.compulsory.Road;

import static edu.compulsory.LocationType.AIRPORT;
import static edu.compulsory.LocationType.CITY;
import static edu.compulsory.RoadType.EXPRESS;
import static edu.compulsory.RoadType.HIGHWAY;

public class Main {
    public static void main(String[] args){
        Location c1 = new Location();
        c1.setName("Iasi");
        c1.setType(CITY);
        c1.setX(2.4);
        c1.setY(6.0);
        System.out.println(c1);

        Location c2 = new Location("Vama Veche", CITY, 78.0, 120.5);
        System.out.println(c2);

        Location c3 = new Location("Onesti", CITY, 35.0, 40.0);

        Road e1 = new Road( EXPRESS, 5, 80, c1, c2);
        System.out.println(e1);

        Location a1 = new Location();
        a1.setName("LAX");
        a1.setType(AIRPORT);
        a1.setX(128.4);
        a1.setY(2083.9);
        System.out.println(a1);

        Road h1 = new Road();
        h1.setType(HIGHWAY);
        h1.setNode1(a1);
        h1.setNode2(c3);
        h1.setLength(127400);
        h1.setSpeedLimit(130);
        System.out.println(h1);
    }
}
