package leetcode.problems.q51;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int n;
    private List<List<String>> answers;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        answers = new ArrayList<>();
        int[] chess = new int[n];
        for (int i = 0; i < n; i++) {
            chess[0] = i;
            nextNQueens(chess, 1);
        }

        return answers;
    }

    private void nextNQueens(int[] chess, int row) {

        if (row == n) {
            List<String> answer = new ArrayList<>();
            for (int i = 0; i < chess.length; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < chess.length; j++) {
                    if (chess[i] == j) {
                        sb.append('Q');
                        continue;
                    }
                    sb.append('.');
                }
                answer.add(sb.toString());
            }
            answers.add(answer);
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