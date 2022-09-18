package leetcode.problems.q516;

class Solution {

    private int answer = 1;
    private int[][] dp;
    private String s;

    public int longestPalindromeSubseq(String s) {

        int length = s.length();
        this.dp = new int[length][length];
        this.s = s;

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (i == j) {
                    continue;
                }

                answer = Math.max(answer, dfs(i, j));
            }
        }

        return answer;
    }

    private int dfs(int start, int end) {

        if (start > end) {
            return 0;
        }

        if (dp[start][end] > 0) {
            return dp[start][end];
        }

        if (start + 1 == end && s.charAt(start) == s.charAt(end)) {
            dp[start][end] = 2;
            return 2;
        }

        if (start + 1 == end && s.charAt(start) != s.charAt(end)) {
            dp[start][end] = 1;
            return 1;
        }

        if (s.charAt(start) != s.charAt(end)) {
            dp[start][end] = Math.max(dfs(start + 1, end), dfs(start, end - 1));
        } else {
            dp[start][end] = 2 + dfs(start + 1, end - 1);
        }

        return dp[start][end];
    }
}