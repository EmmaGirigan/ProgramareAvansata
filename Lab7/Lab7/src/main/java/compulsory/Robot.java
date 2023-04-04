package compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Robot implements Runnable{
    private String name;
    private Cell location;
    private boolean running;
    Exploration explore;
    public Robot(String name) {
        this.name = name;
    }
    public void setInitialLocation(int n){
        Cell cell = new Cell(randomIndex(n), randomIndex(n));
        while(cell.isVisited()){
            cell = new Cell(randomIndex(n), randomIndex(n));
        }
        this.location = cell;
    }
    public void setNextLocation(int n){
        int row = this.location.getRow();
        int col = this.location.getCol();
        List<Integer> rowOptions = new ArrayList<>();

    }

    public void moveUp(int row, int col){
        this.location.setRow(row-1);
    }
    public void moveDown(int row, int col){
        this.location.setRow(row+1);
    }
    public void moveLeft(int row, int col){
        this.location.setCol(col-1);
    }
    public void moveRight(int row, int col){
        this.location.setCol(col+1);
    }
    public void moveDiagonalUpRight(int row, int col){
        this.location.setRow(row-1);
        this.location.setCol(col+1);
    }
    public void moveDiagonalUpLeft(int row, int col){
        this.location.setRow(row-1);
        this.location.setCol(col-1);
    }
    public void moveDiagonalDownRight(int row, int col){
        this.location.setRow(row+1);
        this.location.setCol(col+1);
    }
    public void moveDiagonalDownLeft(int row, int col){
        this.location.setRow(row+1);
        this.location.setCol(col-1);
    }
    private int randomIndex(int n){
        Random random = new Random();
        return random.nextInt(n);
    }
    public void run() {
        while (running) {
            //explore.getMap().visit(row, col, this);
            explore.getMap().visit(this.location, this);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
