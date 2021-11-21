package problems.q64;

class Solution {

    private int[][] dp;

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];

        dp[0][0] = grid[0][0];

        initFirstRow(grid, m);
        initFirstColumn(grid, n);
        calculatePaths(grid, m, n);
        return dp[m - 1][n - 1];
    }


    private void calculatePaths(int[][] grid, int m, int n) {
        for (int row = 1; row < m; row++) {
            for (int column = 1; column < n; column++) {
                dp[row][column] = Math.min(dp[row - 1][column], dp[row][column - 1]) + grid[row][column];
            }
        }
    }

    private void initFirstColumn(int[][] grid, int n) {
        for (int column = 1; column < n; column++) {
            dp[0][column] = dp[0][column - 1] + grid[0][column];
        }
    }

    private void initFirstRow(int[][] grid, int m) {

        for (int row = 1; row < m; row++) {

            dp[row][0] = dp[row - 1][0] + grid[row][0];
        }
    }
}