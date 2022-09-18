package leetcode.problems.q1091;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    private static int[][] DIRECTIONS = {{1, 1}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] == 1) {
            return -1;
        }

        int n = grid[0].length;

        if (n == 1) {
            return grid[0][0] == 1 ? -1 : 1;
        }

        Queue<Path> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][n];

        queue.add(new Path(0, 0, 1));
        visit[0][0] = true;
        while (!queue.isEmpty()) {
            Path current = queue.poll();

            for (int[] DIRECTION : DIRECTIONS) {

                int nextY = current.y + DIRECTION[0];
                int nextX = current.x + DIRECTION[1];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n || visit[nextY][nextX] || grid[nextY][nextX] == 1) {
                    continue;
                }

                if (nextX == n - 1 && nextY == n - 1) {
                    return current.count + 1;
                }

                visit[nextY][nextX] = true;
                queue.add(new Path(nextX, nextY, current.count + 1));
            }
        }

        return -1;
    }

    private static class Path {
        int x;
        int y;
        int count;

        public Path(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}