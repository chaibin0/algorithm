package leetcode.problems.q1162;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private int[][] dp;
    private final int[][] MOVES = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int maxDistance(int[][] grid) {
        int n = grid.length;

        this.dp = new int[n][n];
        int answer = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    answer = Math.max(answer, bfs(grid, i, j));
                }
            }
        }

        return answer;
    }

    private int bfs(int[][] grid, int i, int j) {

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{i, j});

        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        visit[i][j] = true;

        int result = Integer.MAX_VALUE;
        int count = 0;
        boolean isEnd = false;

        while (!dq.isEmpty()) {
            count++;
            Deque<int[]> dq2 = new ArrayDeque<>();

            while (!dq.isEmpty()) {
                int[] current = dq.pollFirst();
                visit[current[0]][current[1]] = true;


                for (int[] move : MOVES) {
                    int nextY = current[0] + move[0];
                    int nextX = current[1] + move[1];

                    if (nextY < 0 || nextX < 0 || nextX >= n || nextY >= n) {
                        continue;
                    }

                    if (dp[nextY][nextX] != 0) {
                        result = Math.min(result, count + dp[nextY][nextX]);
                        continue;
                    }

                    if (grid[nextY][nextX] == 1) {
                        isEnd = true;
                        result = Math.min(result, count);
                        break;
                    }

                    if (visit[nextY][nextX]) {
                        continue;
                    }

                    if (count > result) {
                        isEnd = true;
                        break;
                    }
                    dq2.addLast(new int[]{nextY, nextX});
                }

                if (isEnd) {
                    break;
                }
            }

            while (!dq2.isEmpty()) {
                dq.addLast(dq2.pollFirst());
            }

            if (isEnd) {
                break;
            }
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        }

        dp[i][j] = result;
        return result;
    }
}

