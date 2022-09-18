package leetcode.problems.q304;

class NumMatrix {

    private int[][] dp;

    public NumMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        this.dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int left = (j - 1) < 0 ? 0 : this.dp[i][j - 1];
                int up = (i - 1) < 0 ? 0 : this.dp[i - 1][j];
                int leftUp = (j - 1) < 0 || (i - 1) < 0 ? 0 : this.dp[i - 1][j - 1];
                this.dp[i][j] = matrix[i][j] + left + up - leftUp;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int left = (col1 - 1) < 0 ? 0 : dp[row2][col1 - 1];
        int up = (row1 - 1) < 0 ? 0 : dp[row1 - 1][col2];
        int leftUp = (col1 - 1) < 0 || (row1 - 1) < 0 ? 0 : dp[row1 - 1][col1 - 1];

        return this.dp[row2][col2] + leftUp - left - up;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */