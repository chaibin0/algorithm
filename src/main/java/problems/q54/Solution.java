package problems.q54;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static int[][] turnAroundArr = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    private int m;
    private int n;
    private boolean[][] visit;

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> answer = new ArrayList<>();
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.visit = new boolean[m][n];

        int position = 0;
        int posX = -1;
        int posY = 0;

        while (canGoNext(posX, posY, position)) {

            while (canGoNext(posX, posY, position)) {
                posX = posX + turnAroundArr[position][0];
                posY = posY + turnAroundArr[position][1];
                answer.add(matrix[posY][posX]);
                visit[posY][posX] = true;
            }
            position = (position + 1) % 4;
        }

        return answer;
    }

    private boolean canGoNext(int posX, int posY, int position) {

        int[] currentTurnAround = turnAroundArr[position];
        int nextPosX = posX + currentTurnAround[0];
        int nextPosY = posY + currentTurnAround[1];

        if (nextPosX >= n || nextPosX < 0) {
            return false;
        }

        if (nextPosY >= m || nextPosY < 0) {
            return false;
        }

        return !visit[nextPosY][nextPosX];
    }
}