package leetcode.problems.q1905;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    private final int[][] MOVES = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private int m;
    private int n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        this.m = grid1.length;
        this.n = grid1[0].length;
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && isSubIsland(grid1, grid2, i, j)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean isSubIsland(int[][] grid1, int[][] grid2, int yPos, int xPos) {

        boolean flag = true;
        if (grid1[yPos][xPos] != grid2[yPos][xPos]) {
            flag = false;
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{yPos, xPos});
        grid2[yPos][xPos] = 0;

        while (!dq.isEmpty()) {
            int[] current = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextY = current[0] + MOVES[i][0];
                int nextX = current[1] + MOVES[i][1];

                if (isBoundary(nextY, nextX) || grid2[nextY][nextX] == 0) {
                    continue;
                }

                if (grid1[nextY][nextX] != 1 || grid2[nextY][nextX] != 1) {
                    flag = false;
                }

                dq.add(new int[]{nextY, nextX});
                grid2[nextY][nextX] = 0;
            }
        }

        return flag;
    }

    private boolean isBoundary(int y, int x) {
        return y < 0 || x < 0 || y >= m || x >= n;
    }
}