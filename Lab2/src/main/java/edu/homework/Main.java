package edu.homework;

import edu.homework.Location;
import edu.homework.Road;
import edu.homework.Problem;

import static edu.compulsory.RoadType.EXPRESS;
import static edu.compulsory.RoadType.HIGHWAY;
import static edu.compulsory.RoadType.COUNTRY;

public class Main {
    public static void main(String[] args){
        Location c1 = new Town("Iasi", 2.4, 6.0, 1000);
        Location c2 = new Town("Vama Veche", 78.0, 138.5, 1000);
        Location c3 = new Town("Iasi", 2.4, 6.0, 1000);
        Location a1 = new Airport("LAX", 128.4, 2083.9, 5);
        Location g1 = new GasStation("Peco", 13.0, 241.2, 5.7);
        Location a2 = new Airport(7);

        Road e1 = new Road( EXPRESS, 200, 80, c1, c2);
        Road h1 = new Road(HIGHWAY, 3000, 130, a1, c2);

        Location[] locations = new Location[4];
        locations[0] = c1;
        locations[1] = c2;
        locations[2] = a1;
        Road[] roads = new Road[2];
        roads[0] = e1;
        roads[1] = h1;

        Problem problem = new Problem(locations, roads);
        System.out.println(problem);
        problem.isValidInstance();
    }
}