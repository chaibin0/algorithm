package leetcode.problems.q1162;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxDistance() {

        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        assertEquals(2, new Solution().maxDistance(grid));
    }

    @Test
    void maxDistance2() {

        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertEquals(4, new Solution().maxDistance(grid));
    }

    @Test
    void maxDistance3() {

        int[][] grid = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertEquals(-1, new Solution().maxDistance(grid));
    }
}