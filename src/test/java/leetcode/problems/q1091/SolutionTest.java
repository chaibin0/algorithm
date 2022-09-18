package leetcode.problems.q1091;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void shortestPathBinaryMatrix1() {

        int[][] grid = {{0, 1}, {1, 0}};
        assertEquals(2, new Solution().shortestPathBinaryMatrix(grid));
    }

    @Test
    void shortestPathBinaryMatrix2() {

        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 0, 0}};
        assertEquals(4, new Solution().shortestPathBinaryMatrix(grid));
    }

    @Test
    void shortestPathBinaryMatrix3() {

        int[][] grid = {{1, 0, 0}, {1, 1, 0}, {1, 0, 0}};
        assertEquals(-1, new Solution().shortestPathBinaryMatrix(grid));
    }
}