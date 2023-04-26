package compulsory;

import java.util.Arrays;

public class ExplorationMap {
    private final int n;
    public ExplorationMap(int n, SharedMemory memory) {
        matrix = new Cell[n][n];
        this.n = n;
        this.sharedMemory = memory;
    }

    private final SharedMemory sharedMemory;

    private final Cell[][] matrix;

    public Cell[][] getMap() {
        return matrix;
    }

    public int getN() {
        return n;
    }
    public void visit(Cell cell, Robot robot) {
        synchronized (cell) {
            if(!cell.isVisited()) {
                cell.setTokens(sharedMemory.extractTokens(n));
                cell.setVisited(true);
                System.out.println("Got the tokens!\n");
            }
        }
    }

    @Override
    public String toString() {
        return "ExplorationMap{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
