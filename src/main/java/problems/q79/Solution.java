package problems.q79;

class Solution {
    private boolean[][] visited;
    private char[][] board;
    private String word;
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;
        this.visited = new boolean[m][n];

        boolean answer = false;

        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (board[row][column] == word.charAt(0)) {
                    answer = searchWord(row, column, 1);

                }

                if (answer) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchWord(int currentRow, int currentColumn, int currentSize) {

        if (visited[currentRow][currentColumn]) {
            return false;
        }

        if (this.word.length() == currentSize) {
            return true;
        }

        boolean answer;
        int index = currentRow * this.n + currentColumn;

        visited[currentRow][currentColumn] = true;

        if (currentRow - 1 >= 0 && this.board[currentRow - 1][currentColumn] == word.charAt(currentSize)) {
            answer = searchWord(currentRow - 1, currentColumn, currentSize + 1);
            if (answer) return true;
        }

        if (currentRow + 1 < m && this.board[currentRow + 1][currentColumn] == word.charAt(currentSize)) {
            answer = searchWord(currentRow + 1, currentColumn, currentSize + 1);
            if (answer) return true;
        }

        if (currentColumn - 1 >= 0 && this.board[currentRow][currentColumn - 1] == word.charAt(currentSize)) {
            answer = searchWord(currentRow, currentColumn - 1, currentSize + 1);
            if (answer) return true;
        }

        if (currentColumn + 1 < n && this.board[currentRow][currentColumn + 1] == word.charAt(currentSize)) {
            answer = searchWord(currentRow, currentColumn + 1, currentSize + 1);
            if (answer) return true;
        }

        visited[currentRow][currentColumn] = false;
        return false;
    }
}