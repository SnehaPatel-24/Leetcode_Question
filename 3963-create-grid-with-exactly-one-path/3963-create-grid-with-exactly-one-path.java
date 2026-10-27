import java.util.Arrays;

class Solution {
    public String[] createGrid(int m, int n) {
        // Step 1: Initialize grid with all obstacles '#'
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }

        // Step 2: Path along the first row (0, 0) to (0, n - 1)
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }

        // Step 3: Path down the last column (0, n - 1) to (m - 1, n - 1)
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }

        // Step 4: Convert char[][] to String[]
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }

        return result;
    }
}