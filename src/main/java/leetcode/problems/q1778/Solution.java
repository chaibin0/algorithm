package leetcode.problems.q1778;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 */

class GridMaster {
    boolean canMove(char direction) {
        return false;
    }

    void move(char direction) {

    }

    boolean isTarget() {
        return false;
    }
}

class Solution {

    private final static char[] directions = {'U', 'L', 'D', 'R'};
    private final static int[][] faces = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    int[][] grid;
    boolean[][] visited;

    public int findShortestPath(GridMaster master) {
        int x = 501;
        int y = 501;
        this.grid = new int[1002][1002];
        this.visited = new boolean[1002][1002];

        makeGrid(master, true, x, y);

        int answer = 1;


        Queue<int[]> outerQueue = new ArrayDeque<>();
        outerQueue.add(new int[]{x, y});

        this.visited = new boolean[1002][1002];
        while (!outerQueue.isEmpty()) {

            Queue<int[]> innerQueue = new ArrayDeque<>();
            while (!outerQueue.isEmpty()) {
                innerQueue.add(outerQueue.poll());
            }

            while (!innerQueue.isEmpty()) {

                int[] currentPosition = innerQueue.poll();

                for (int[] face : faces) {

                    int nextX = currentPosition[0] + face[0];
                    int nextY = currentPosition[1] + face[1];

                    if (this.visited[nextY][nextX] || this.grid[nextY][nextX] == 0) {
                        continue;
                    }

                    if (this.grid[nextY][nextX] == 2) {
                        return answer;
                    }
                    this.visited[nextY][nextX] = true;
                    outerQueue.add(new int[]{nextX, nextY});
                }
            }

            answer++;
        }

        return -1;
    }

    private void makeGrid(GridMaster master, boolean isFirst, int x, int y) {

        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;
        if (isFirst) {
            this.grid[y][x] = -1;
        } else if (master.isTarget()) {
            this.grid[y][x] = 2;
        } else {
            this.grid[y][x] = 1;
        }

        for (int i = 0; i < 4; i++) {
            char direction = directions[i];
            if (!master.canMove(direction)) {
                this.grid[y + faces[i][1]][x + faces[i][0]] = 0;
                continue;
            }

            master.move(directions[i]);
            makeGrid(master, false, x + faces[i][0], y + faces[i][1]);
            master.move(directions[(i + 2) % 4]);
        }
    }
}


