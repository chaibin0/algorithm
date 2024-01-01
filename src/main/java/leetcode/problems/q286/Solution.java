package leetcode.problems.q286;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    private static final int INF = 2147483647;
    private static final int GATE = 0;
    private static final int[][] POSITIONS = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };


    public void wallsAndGates(int[][] rooms) {

        int m = rooms.length;
        int n = rooms[0].length;

        Queue<Index> positionQueue = new ArrayDeque<>();

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (rooms[y][x] == GATE) {
                    positionQueue.add(new Index(y, x));
                }
            }
        }

        while (!positionQueue.isEmpty()) {
            Index index = positionQueue.poll();

            for (int[] POSITION : POSITIONS) {
                int nextY = index.y + POSITION[0];
                int nextX = index.x + POSITION[1];

                if (nextY >= m || nextY < 0 || nextX >= n || nextX < 0 || rooms[nextY][nextX] != INF) {
                    continue;
                }

                rooms[nextY][nextX] = rooms[index.y][index.x] + 1;
                positionQueue.add(new Index(nextY, nextX));
            }
        }

    }
}

class Index {
    int y;
    int x;

    public Index(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
