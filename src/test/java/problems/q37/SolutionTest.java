package problems.q37;

import answers.q37.Solution2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void solveSudoku() {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] output = {
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'}
                , {'6', '7', '2', '1', '9', '5', '3', '4', '8'}
                , {'1', '9', '8', '3', '4', '2', '5', '6', '7'}
                , {'8', '5', '9', '7', '6', '1', '4', '2', '3'}
                , {'4', '2', '6', '8', '5', '3', '7', '9', '1'}
                , {'7', '1', '3', '9', '2', '4', '8', '5', '6'}
                , {'9', '6', '1', '5', '3', '7', '2', '8', '4'}
                , {'2', '8', '7', '4', '1', '9', '6', '3', '5'}
                , {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};

        Solution solution = new Solution();
        solution.solveSudoku(board);

        assertThat(board).isEqualTo(output);
    }

    @Test
    void solveSudoku2() {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] output = {
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'}
                , {'6', '7', '2', '1', '9', '5', '3', '4', '8'}
                , {'1', '9', '8', '3', '4', '2', '5', '6', '7'}
                , {'8', '5', '9', '7', '6', '1', '4', '2', '3'}
                , {'4', '2', '6', '8', '5', '3', '7', '9', '1'}
                , {'7', '1', '3', '9', '2', '4', '8', '5', '6'}
                , {'9', '6', '1', '5', '3', '7', '2', '8', '4'}
                , {'2', '8', '7', '4', '1', '9', '6', '3', '5'}
                , {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};

        Solution2 solution = new Solution2();
        solution.solveSudoku(board);

        assertThat(board).isEqualTo(output);
    }
}