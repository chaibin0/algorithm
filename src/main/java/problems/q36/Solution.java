package problems.q36;


/*
        char[][] board =
                {
                          {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean isValid = true;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] != '.' && !checkPosition(row, column, board)) {
                    isValid = false;
                }
            }
        }

        return isValid;
    }

    private boolean checkPosition(int row, int column, char[][] board) {

        int value = board[row][column];

        for (int i = 0; i < 9; i++) {
            if (i != column && board[row][i] == value) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][column] == value) {
                return false;
            }
        }

        int subBoxRow = row / 3 * 3;
        int subBoxColumn = column / 3 * 3;

        for (int r = subBoxRow; r < subBoxRow + 3; r++) {
            for (int c = subBoxColumn; c < subBoxColumn + 3; c++) {
                if (r == row && c == column) {
                    continue;
                }

                if (board[r][c] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}