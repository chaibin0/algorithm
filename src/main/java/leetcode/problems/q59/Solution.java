package leetcode.problems.q59;

class Solution {

    private static int[][] turnAroundArr = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    private boolean[][] visit;
    private int n;

    public int[][] generateMatrix(int n) {
        this.n = n;
        int[][] matrix = new int[n][n];
        this.visit = new boolean[n][n];
        int position = 0;

        int posX = -1;
        int posY = 0;
        int index = 1;
        while (canGoNext(posX, posY, position)) {

            while (canGoNext(posX, posY, position)) {
                posX = posX + turnAroundArr[position][0];
                posY = posY + turnAroundArr[position][1];
                matrix[posY][posX] = index++;
                visit[posY][posX] = true;
            }
            position = (position + 1) % 4;
        }

        return matrix;
    }

    private boolean canGoNext(int posX, int posY, int position) {

        int[] currentTurnAround = turnAroundArr[position];
        int nextPosX = posX + currentTurnAround[0];
        int nextPosY = posY + currentTurnAround[1];

        if (nextPosX >= n || nextPosX < 0) {
            return false;
        }

        if (nextPosY >= n || nextPosY < 0) {
            return false;
        }

        return !visit[nextPosY][nextPosX];
    }
}