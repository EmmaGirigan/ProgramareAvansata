package edu.homework;

import java.util.Arrays;
import java.util.List;

public class Problem {
    private Location[] locations;
    private Road[] roads;

    public Problem(){}
    public Problem(Location[] locations, Road[] roads) {
        if(noDuplicates(locations)) this.locations = locations;
        if(noDuplicates(roads)) this.roads = roads;
    }

    public Location[] getLocations() {
        return locations;
    }

    public Road[] getRoads() {
        return roads;
    }

    public void setLocations(Location[] locations) {
        if(noDuplicates(locations)) this.locations = locations;
    }

    public void setRoads(Road[] roads) {
        if(noDuplicates(roads)) this.roads = roads;
    }

    /**
     * Metoda verifica daca instanta este valida, prin verificarea urmatoarelor conditii:
     * - drumurile din instanta sa nu se conecteze la locatii nule
     * - drumurile din instanta sa nu conecteze locatii care nu se fac parte din instanta
     * Afiseaza un mesaj si incheie programul daca instanta nu este valida
     */
    public void isValidInstance(){
        for (Road road : roads){
            if(road.getNode1() == null || road.getNode2() == null){
                System.out.println("Instance not valid -> A road connects to a location that is null");
                System.exit(0);
            }
        }
        List<Location> locations = Arrays.asList(this.getLocations());
        for (Road road : roads) {
            boolean checkNode1 = locations.contains(road.getNode1());
            boolean checkNode2 = locations.contains(road.getNode2());
            if(checkNode1 == false || checkNode2 == false){
                System.out.println("Instance not valid -> A road connects some locations that aren't in the location array");
                System.exit(0);
            }
        }
        System.out.println("Instance valid");
    }

    /**
     * Metoda verifica daca exista doua sau mai multe obiecte identice folosind metoda equals
     * @param o Un obiect
     * @return fals daca exista doua sau mai multe obiecte identice, adevarat daca toate obiectele sunt unice
     */
    public boolean noDuplicates(Object[] o){
        for(int i = 0; i < o.length-1; i++){
            for(int j = i+1; j < o.length; j++){
                if(o[i].equals(o[j])){
                    System.out.printf("Can't add location %s, already exists%n", o[i].toString());
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "locations=" + Arrays.toString(locations) +
                ", roads=" + Arrays.toString(roads) +
                '}';
    }
}
