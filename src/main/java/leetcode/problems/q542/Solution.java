package leetcode.problems.q542;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    private static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];

        Queue<int[]> targetQueue = new ArrayDeque<>();
        Queue<int[]> deleteQueue = new ArrayDeque<>();
        Queue<int[]> queue2 = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    queue2.add(new int[]{i, j});
                }
            }
        }
        while (!queue2.isEmpty()) {

            while (!queue2.isEmpty()) {
                targetQueue.add(queue2.poll());
            }

            while (!deleteQueue.isEmpty()) {
                int[] current = deleteQueue.poll();
                mat[current[0]][current[1]] = 0;
            }

            while (!targetQueue.isEmpty()) {
                int[] current = targetQueue.poll();

                boolean canGoZero = false;
                for (int[] DIRECTION : DIRECTIONS) {
                    int nextY = current[0] + DIRECTION[0];
                    int nextX = current[1] + DIRECTION[1];

                    if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                        continue;
                    }

                    if (mat[nextY][nextX] == 0) {
                        dp[current[0]][current[1]] = dp[nextY][nextX] + 1;
                        canGoZero = true;
                        break;
                    }
                }

                if (!canGoZero) {
                    queue2.add(current);
                } else {
                    deleteQueue.add(current);
                }
            }
        }

        return dp;
    }
}