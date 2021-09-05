package problems.q37;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    private boolean success = false;

    public void solveSudoku(char[][] board) {

        if (isSuccess(board)) {
            this.success = true;
            return;
        }

        boolean isChecked = false;

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {

                    Set<Character> possibleNumberGroup = getPossibleNumber(row, column, board);

                    if (!possibleNumberGroup.isEmpty()) {
                        isChecked = true;
                    }

                    for (char num : possibleNumberGroup) {
                        board[row][column] = num;
                        solveSudoku(board);
                        if (success) {
                            return;
                        }
                        board[row][column] = '.';
                    }
                }
            }

            if (isChecked) {
                return;
            }
        }
    }

    private boolean isSuccess(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {
                    return false;
                }
            }
        }

        return true;
    }

    private Set<Character> getPossibleNumber(int row, int column, char[][] board) {

        Set<Character> possibleList = IntStream.rangeClosed(1, 9)
                .boxed()
                .map((num) -> (char) ('0' + num))
                .collect(Collectors.toSet());

        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.') {
                possibleList.remove(board[row][i]);
            }

            if (board[i][column] != '.') {
                possibleList.remove(board[i][column]);
            }
        }

        int boxedRow = row - row % 3;
        int boxedColumn = column - column % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxedRow + i][boxedColumn + j] != '.') {
                    possibleList.remove(board[boxedRow + i][boxedColumn + j]);
                }
            }
        }
        return possibleList;
    }
}