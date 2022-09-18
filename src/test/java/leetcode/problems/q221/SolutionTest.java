package leetcode.problems.q221;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maximalSquare() {

        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        assertEquals(4, new Solution().maximalSquare(matrix));
    }

    @Test
    void maximalSquare2() {

        char[][] matrix = {{'0'}};

        assertEquals(0, new Solution().maximalSquare(matrix));
    }

    @Test
    void maximalSquare3() {

        char[][] matrix =
                {{'0','0','0','1','0','1','1','1'},
                {'0','1','1','0','0','1','0','1'},
                {'1','0','1','1','1','1','0','1'},
                {'0','0','0','1','0','0','0','0'},
                {'0','0','1','0','0','0','1','0'},
                {'1','1','1','0','0','1','1','1'},
                {'1','0','0','1','1','0','0','1'},
                {'0','1','0','0','1','1','0','0'},
                {'1','0','0','1','0','0','0','0'}};

        assertEquals(1, new Solution().maximalSquare(matrix));
    }
    
}