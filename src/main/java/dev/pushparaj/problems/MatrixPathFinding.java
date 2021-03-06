package dev.pushparaj.problems;

import java.util.*;

public class MatrixPathFinding {

    public static final int BLOCKED = -1;

    public static void printPaths(int[][] matrix, int sourceX, int sourceY,  int destX, int destY) {
        findPaths(matrix, sourceX, sourceY, destX, destY, new ArrayList<>(), 0);
    }

    private static void findPaths(int[][] matrix, int currX, int currY, int destX, int destY, List<Integer[]> currentPath, int currentCost) {
        currentPath.add(new Integer[]{currX, currY});
        currentCost += matrix[currX][currY];
        if(currX == destX && currY == destY) {
            StringBuilder sb = new StringBuilder();
            for(Integer[] arr : currentPath) {
                sb.append("(" + arr[0] + "," + arr[1] + ")");
            }
            System.out.println("Valid Path : " + sb.toString() + " Cose : " + currentCost);
            currentPath.remove(currentPath.size() - 1);
            return;
        }
        int maxRowIndex = matrix.length - 1;
        int maxColumIndex = matrix[0].length - 1;

        
        //Try to move down 
        if(currX + 1 <= maxRowIndex && matrix[currX + 1][currY] != BLOCKED && !contains(currentPath, currX + 1, currY)) {
            findPaths(matrix, currX + 1, currY, destX, destY, currentPath, currentCost);
        }

        //Try to move up
        if(currX - 1 >= 0 && matrix[currX - 1][currY] != BLOCKED && !contains(currentPath, currX - 1, currY)) {
            findPaths(matrix, currX - 1, currY, destX, destY, currentPath, currentCost);
        }

        //Try to move right
        if(currY + 1 <= maxColumIndex && matrix[currX][currY + 1] != BLOCKED && !contains(currentPath, currX, currY + 1)) {
            findPaths(matrix, currX, currY + 1, destX, destY, currentPath, currentCost);
        }

        //Try to move left
        if(currY - 1 >= 0 && matrix[currX][currY - 1] != BLOCKED && !contains(currentPath, currX, currY - 1)) {
            findPaths(matrix, currX, currY - 1, destX, destY, currentPath, currentCost);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    private static boolean contains(List<Integer[]> cells, int x, int y) {
        for(Integer[] arr : cells) {
            if(x == arr[0] && y == arr[1])
                return true;
        }
        return false;
    }
}