package leetcode.problems.q1254;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    @Test
    void closedIsland() {

        int[][] grid = {
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 1, 0, 1, 0, 1, 0, 0, 1, 0}
        };

        assertThat(new Solution().closedIsland(grid)).isEqualTo(4);
    }
}