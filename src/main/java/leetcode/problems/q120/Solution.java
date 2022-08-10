package leetcode.problems.q120;

import java.util.Arrays;
import java.util.List;

/*
2
3 4
6 5 7
4 1 8 3
2
5 6
6 5 7
11 10 13
 */


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[200][200];

        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[0][0] = triangle.get(0).get(0);
        int triangleSize = triangle.size() - 1;
        for (int i = 0; i < triangleSize; i++) {
            int size = triangle.get(i).size();

            for (int j = 0; j < size; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + triangle.get(i + 1).get(j));
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + triangle.get(i + 1).get(j + 1));
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= triangleSize; i++) {
            answer = Math.min(answer, dp[triangleSize][i]);
        }

        return answer;
    }
}

