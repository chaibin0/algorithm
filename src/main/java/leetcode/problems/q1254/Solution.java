package leetcode.problems.q1254;


import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    private int[][] vectors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m;
    private int n;

    public int closedIsland(int[][] grid) {

        this.m = grid.length;
        this.n = grid[0].length;
        int answer = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (0 == grid[row][column] && removeIslands(grid, row, column)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean removeIslands(int[][] grid, int row, int column) {
        Deque<Pair> queue = new ArrayDeque<>();
        grid[row][column] = 1;
        queue.add(new Pair(row, column));
        boolean answer = true;
        while (!queue.isEmpty()) {
            Pair currentPair = queue.pollFirst();

            for (int i = 0; i < vectors.length; i++) {
                int nextColumn = currentPair.column + vectors[i][0];
                int nextRow = currentPair.row + vectors[i][1];
                if (nextRow < 0 || nextRow >= this.m || nextColumn < 0 || nextColumn >= this.n) {
                    answer = false;
                    continue;
                }

                if (grid[nextRow][nextColumn] == 1) {
                    continue;
                }

                grid[nextRow][nextColumn] = 1;
                queue.add(new Pair(nextRow, nextColumn));
            }
        }
        return answer;
    }
}

class Pair {
    int row;
    int column;

    Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}