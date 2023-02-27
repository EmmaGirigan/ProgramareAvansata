package com.example.mypack;

import java.util.Scanner;

public class Homework {
    public static void validateN(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(n + " is less than 1, can't create matrix");
        }
    }
    static int[][] createLatinMatrix(int n)
    {
        int [][] matrix = new int[n][n];
        for(int l = 0; l < n; l++) {
            int pivot = n-l;
            for(int c = 0; c < n; c++){
                pivot++;
                if(pivot <= n){
                    matrix[l][c] = pivot;
                }
                else if(pivot == n+1){
                    pivot = 1;
                    matrix[l][c] = pivot;
                }
            }
        }
        return matrix;
    }

    public static void displayMatrix(int n, int[][] matrix){
        for(int i = 0; i < n; i++){
            String line = new String();
            for(int j = 0; j < n; j++){
                line = line + String.valueOf(matrix[i][j]);
            }
            System.out.printf("Line %d: %s%n", i, line);
        }
        for(int j = 0; j < n; j++){
            String column = new String();
            for(int i = 0; i < n; i++){
                column = column + String.valueOf(matrix[i][j]);
            }
            System.out.printf("Column %d: %s%n", j, column);
        }
    }

    public static void main(String[] args) {
        //int n = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input: ");
        int n = scanner.nextInt();
        validateN(n);
        long startTime = System.nanoTime();
        int [][] matrix = createLatinMatrix(n);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        if(n<20000) displayMatrix(n, matrix);
        else System.out.println(totalTime);
    }
}
