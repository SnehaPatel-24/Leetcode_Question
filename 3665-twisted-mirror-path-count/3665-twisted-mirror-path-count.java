class Solution {
    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1000000007;

        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        // Starting position
        right[0][0] = 1;

        // Traverse the grid
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {

                    // Empty cell: robot can move right or down
                    long ways = (right[i][j] + (long)down[i][j]) % MOD;

                    // Move right
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (int)((right[i][j + 1] + ways) % MOD);
                    }

                    // Move down
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (int)((down[i + 1][j] + ways) % MOD);
                    }

                } else {

                    // Mirror: entered from left, reflect down
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (int)((down[i + 1][j] +
                            (long)right[i][j]) % MOD);
                    }

                    // Mirror: entered from above, reflect right
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (int)((right[i][j + 1] +
                            (long)down[i][j]) % MOD);
                    }
                }
            }
        }

        // Total paths reaching destination
        return (int)((right[m - 1][n - 1] +
                      (long)down[m - 1][n - 1]) % MOD);
    }
}