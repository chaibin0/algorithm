package leetcode.problems.q1020;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    private int m;
    private int n;
    private static final int[][] POSITIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numEnclaves(int[][] grid) {

        this.m = grid.length;
        this.n = grid[0].length;
        int answer = 0;

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int count = checkEnclaves(grid, i, j);
                answer += count;
            }
        }

        return answer;
    }

    private int checkEnclaves(int[][] grid, int i, int j) {

        Deque<int[]> dq = new ArrayDeque<>();

        grid[i][j] = 0;
        dq.add(new int[]{i, j});
        boolean isBoundary = false;
        int count = 0;
        while (!dq.isEmpty()) {

            int[] value = dq.pollFirst();
            count++;
            for (int[] POSITION : POSITIONS) {
                int nextRow = value[0] + POSITION[0];
                int nextColumn = value[1] + POSITION[1];

                if (checkBoundary(nextRow, nextColumn)) {
                    isBoundary = true;
                    continue;
                }

                if (grid[nextRow][nextColumn] == 0) {
                    continue;
                }

                grid[nextRow][nextColumn] = 0;
                dq.add(new int[]{nextRow, nextColumn});
            }
        }

        return isBoundary ? 0 : count;
    }

    private boolean checkBoundary(int nextRow, int nextColumn) {
        return nextRow < 0 || nextColumn < 0 || nextRow >= this.m || nextColumn >= this.n;
    }
}