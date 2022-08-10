package leetcode.problems.q931;



class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int[][] dp = new int[n][n];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int first = j != 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int second = dp[i - 1][j];
                int third = j != (n - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(Math.min(first, second), third);
            }
        }

        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, dp[n - 1][i]);
        }

        return answer;
    }
}