package compulsory;

import java.util.ArrayList;
import java.util.List;

public class Exploration extends Thread{

    private int n;
    private final SharedMemory memory = new SharedMemory(n);
    private final ExplorationMap map = new ExplorationMap(n, memory);
    private final List<Robot> robots = new ArrayList<>();

    public void start() {
        for (Robot robot : robots) {
            Thread thread = new Thread((Runnable) robot);
        }
    }
    public void addRobot(Robot robot){
        robots.add(robot);
    }

    public ExplorationMap getMap(){
        return map;
    }

    public static void main(String[] args) {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }

}
