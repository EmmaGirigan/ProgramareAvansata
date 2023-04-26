package compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cell {
    private int row;
    private int col;
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    private boolean visited = false;
    private List<Token> tokens = new ArrayList<>();
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isValidLocation(int n){
        return this.getRow() >= 0 && this.getRow() <= n && this.getCol() >= 0 && this.getCol() <= n;
    }
    public List<Token> getTokens() {
        return tokens;
    }
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
    @Override
    public String toString() {
        return "Cell{" +
                ", tokens=" + tokens +
                '}';
    }
}
