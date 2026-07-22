package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConflictFreeSensorPlacement {

    public static List<List<String>> placeSensors(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] sensorCol = new int[n];
        backtrack(n, 0, sensorCol, result);
        return result;
    }

    private static void backtrack(int n, int row, int[] sensorCol, List<List<String>> result) {
        if (row == n) {
            result.add(buildGrid(n, sensorCol));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, sensorCol)) {
                sensorCol[row] = col;
                backtrack(n, row + 1, sensorCol, result);
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] sensorCol) {
        for (int r = 0; r < row; r++) {
            if (sensorCol[r] == col) return false;
            if (Math.abs(sensorCol[r] - col) == Math.abs(r - row)) return false;
        }
        return true;
    }

    private static List<String> buildGrid(int n, int[] sensorCol) {
        List<String> grid = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            char[] rowChars = new char[n];
            Arrays.fill(rowChars, '.');
            rowChars[sensorCol[r]] = 'S';
            grid.add(new String(rowChars));
        }
        return grid;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = placeSensors(n);
        System.out.println("Valid sensor placements for " + n + "x" + n + " grid: " + solutions.size());
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
