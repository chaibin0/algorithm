package leetcode.problems.q1958;

class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        board[rMove][cMove] = color;

        return isHorizontalGoodLine(board, rMove, cMove)
                && isVerticalGoodLine(board, rMove, cMove)
                && isRightDownDiagonalGoodLine(board, rMove, cMove)
                && isLeftDownDiagonalGoodLine(board, rMove, cMove);

    }

    private boolean isHorizontalGoodLine(char[][] board, int r, int c) {

        int currentC = c - 1;
        while (currentC >= 0) {
            if (board[r][currentC] == '.') {
                break;
            }
            currentC--;
        }

        currentC++;
        if (currentC == c) {
            return true;
        }

        int change = 0;
        boolean startFlag = board[r][currentC] == 'W';
        boolean flag = startFlag;
        int count = 1;

        currentC++;
        while (currentC < 8) {
            if (board[r][currentC] == '.') {
                break;
            }

            if (count > 3) {
                return false;
            }

            if (flag == (board[r][currentC] == 'W')) {
                count++;
            } else {
                change++;
                count = 1;
                flag = board[r][currentC] == 'W';
            }

            currentC++;
        }

        return change >= 2;
    }

    private boolean isVerticalGoodLine(char[][] board, int r, int c) {

        int currentR = r - 1;
        while (currentR >= 0) {
            if (board[currentR][c] == '.') {
                break;
            }
            currentR--;
        }

        currentR++;

        if (currentR == r) {
            return true;
        }

        int change = 0;
        boolean startFlag = board[currentR][c] == 'W';
        boolean flag = startFlag;
        int count = 1;

        currentR++;
        while (currentR < 8) {
            if (board[currentR][c] == '.') {
                break;
            }

            if (count > 3) {
                return false;
            }

            if (flag == (board[currentR][c] == 'W')) {
                count++;
            } else {
                count = 1;
                change++;
                flag = board[currentR][c] == 'W';
            }
            currentR++;
        }

        return change >= 2;
    }

    private boolean isRightDownDiagonalGoodLine(char[][] board, int r, int c) {

        int currentR = r - 1;
        int currentC = c - 1;

        while (currentC >= 0 && currentR < 8) {
            if (board[currentR][currentC] == '.') {
                break;
            }
            currentR--;
            currentC--;
        }

        currentR++;
        currentC++;

        if (currentR == r && currentC == c) {
            return true;
        }

        int change = 0;
        boolean startFlag = board[currentR][currentC] == 'W';
        boolean flag = startFlag;
        int count = 1;

        currentR++;
        currentC++;

        while (currentC < 8 && currentR < 8) {
            if (board[currentR][currentC] == '.') {
                break;
            }

            if (count > 3) {
                return false;
            }

            if (flag == (board[currentR][currentC] == 'W')) {
                count++;
            } else {
                change++;
                count = 1;
                flag = board[currentR][currentC] == 'W';
            }

            currentR++;
            currentC++;
        }

        return change >= 2;
    }

    private boolean isLeftDownDiagonalGoodLine(char[][] board, int r, int c) {

        int currentR = r;
        int currentC = c;

        while (currentR >= 0 && currentC < 8) {
            if (board[currentR][currentC] == '.') {
                break;
            }
            currentR--;
            currentC++;
        }

        currentR++;
        currentC--;

        if (currentR == r && currentC == c) {
            return true;
        }

        int change = 0;
        boolean startFlag = board[currentR][currentC] == 'W';
        boolean flag = startFlag;
        int count = 1;

        currentR++;
        currentC--;

        while (currentC >= 0 && currentR < 8) {
            if (board[currentR][currentC] == '.') {
                break;
            }

            if (count > 3) {
                return false;
            }

            if (flag == (board[currentR][currentC] == 'W')) {
                count++;
            } else {
                change++;
                count = 1;
                flag = board[currentR][currentC] == 'W';
            }

            currentR++;
            currentC--;
        }

        return change >= 2;
    }
}
