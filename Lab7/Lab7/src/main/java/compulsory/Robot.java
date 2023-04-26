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
        Cell cell = new Cell(randomIndex(), randomIndex());
        while(cell.isVisited()){
            cell = new Cell(randomIndex(), randomIndex());
            System.out.println(cell);
        }
        this.location = cell;
    }
    public void move(int n){
        int row = this.location.getRow();
        int col = this.location.getCol();
        nextLocation(randomIndex(), row, col);
        while(!this.location.isValidLocation(n)){
            nextLocation(randomIndex(), row, col);
        }
    }

    private void nextLocation(int randomMove, int row, int col){
        switch (randomMove) {
            case 0 -> moveUp(row, col);
            case 1 -> moveDown(row, col);
            case 2 -> moveRight(row, col);
            case 3 -> moveLeft(row, col);
            case 4 -> moveDiagonalUpRight(row, col);
            case 5 -> moveDiagonalUpLeft(row, col);
            case 6 -> moveDiagonalDownRight(row, col);
            case 7 -> moveDiagonalDownLeft(row, col);
            default -> {
            }
        }
    }

    private void moveUp(int row, int col){
        this.location.setRow(row-1);
    }
    private void moveDown(int row, int col){
        this.location.setRow(row+1);
    }
    private void moveLeft(int row, int col){
        this.location.setCol(col-1);
    }
    private void moveRight(int row, int col){
        this.location.setCol(col+1);
    }
    private void moveDiagonalUpRight(int row, int col){
        this.location.setRow(row-1);
        this.location.setCol(col+1);
    }
    private void moveDiagonalUpLeft(int row, int col){
        this.location.setRow(row-1);
        this.location.setCol(col-1);
    }
    private void moveDiagonalDownRight(int row, int col){
        this.location.setRow(row+1);
        this.location.setCol(col+1);
    }
    private void moveDiagonalDownLeft(int row, int col){
        this.location.setRow(row+1);
        this.location.setCol(col-1);
    }
    private int randomIndex(){
        Random random = new Random();
        return random.nextInt(8);
    }
    public void run() {
        while (running) {
            explore.getMap().visit(this.location, this);
            this.move(explore.getN());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", running=" + running +
                ", explore=" + explore +
                '}';
    }
}
