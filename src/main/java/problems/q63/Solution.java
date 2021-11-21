package problems.q63;

class Solution {

    private int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        dp[0][0] = 1;
        initFirstRow(obstacleGrid, m);
        initFirstColumn(obstacleGrid, n);
        calculatePaths(obstacleGrid, m ,n);
        return dp[m - 1][n - 1];
    }

    private void calculatePaths(int[][] obstacleGrid, int m, int n) {
        for (int row = 1; row < m; row++) {
            for (int column = 1; column < n; column++) {
                if (obstacleGrid[row][column] == 1) {
                    continue;
                }

                dp[row][column] = dp[row - 1][column] + dp[row][column - 1];
            }
        }
    }

    private void initFirstColumn(int[][] obstacleGrid, int n) {
        for (int column = 1; column < n; column++) {
            if (obstacleGrid[0][column] == 1) {
                break;
            }
            dp[0][column] = 1;
        }
    }

    private void initFirstRow(int[][] obstacleGrid, int m) {

        for (int row = 1; row < m; row++) {
            if (obstacleGrid[row][0] == 1) {
                break;
            }
            dp[row][0] = 1;
        }
    }
}
