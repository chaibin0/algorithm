package problems.q52;

class Solution {

    private int n;
    private int answers;

    public int totalNQueens(int n) {
        this.n = n;
        this.answers = 0;
        int[] chess = new int[n];
        for (int i = 0; i < n; i++) {
            chess[0] = i;
            nextNQueens(chess, 1);
        }

        return answers;
    }

    private void nextNQueens(int[] chess, int row) {

        if (row == n) {
            answers++;
        }

        for (int i = 0; i < n; i++) {
            if (canPutQueen(chess, row, i)) {
                chess[row] = i;
                nextNQueens(chess, row + 1);
            }
        }
    }

    private boolean canPutQueen(int[] chess, int row, int column) {

        for (int i = 0; i < row; i++) {
            if (chess[i] == column) {
                return false;
            }

            if (Math.abs(column - chess[i]) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }
}