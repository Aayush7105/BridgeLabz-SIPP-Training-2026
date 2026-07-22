package Recursion;

public class LogErrorCodeSearch {

    public static boolean exists(char[][] grid, String word) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtrack(grid, word, 0, r, c, visited)) return true;
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] grid, String word, int idx, int r, int c, boolean[][] visited) {
        if (idx == word.length()) return true;
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return false;
        if (visited[r][c] || grid[r][c] != word.charAt(idx)) return false;

        visited[r][c] = true;
        boolean found = backtrack(grid, word, idx + 1, r + 1, c, visited)
                || backtrack(grid, word, idx + 1, r - 1, c, visited)
                || backtrack(grid, word, idx + 1, r, c + 1, visited)
                || backtrack(grid, word, idx + 1, r, c - 1, visited);

        visited[r][c] = false;
        return found;
    }

    public static void main(String[] args) {
        char[][] logGrid = {
            {'E', 'R', 'R', 'O'},
            {'X', 'F', 'A', 'R'},
            {'I', 'N', 'I', 'T'}
        };

        System.out.println("Exists ERR: " + exists(logGrid, "ERR"));
        System.out.println("Exists INIT: " + exists(logGrid, "INIT"));
        System.out.println("Exists FAIL: " + exists(logGrid, "FAIL"));
    }
}
