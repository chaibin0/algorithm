package leetcode.problems.q542;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void updateMatrix() {

        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] result = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        assertThat(new Solution().updateMatrix(mat)).isEqualTo(result);
    }

    @Test
    void updateMatrix2() {

        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] result = {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}};
        assertThat(new Solution().updateMatrix(mat)).isEqualTo(result);
    }

    @Test
    void updateMatrix3() {

        int[][] mat = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 0, 0, 0, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
        };
        int[][] result = {
                {2, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 2, 2, 1},
                {1, 1, 1, 0, 0, 1, 2, 2, 1, 0},
                {0, 1, 2, 1, 0, 1, 2, 3, 2, 1},
                {0, 0, 1, 2, 1, 2, 1, 2, 1, 0},
                {1, 1, 2, 3, 2, 1, 0, 1, 1, 1},
                {0, 1, 2, 3, 2, 1, 1, 0, 0, 1},
                {1, 2, 1, 2, 1, 0, 0, 1, 1, 2},
                {0, 1, 0, 1, 1, 0, 1, 2, 2, 3},
                {1, 2, 1, 0, 1, 0, 1, 2, 3, 4}
        };

        assertThat(new Solution().

                updateMatrix(mat)).

                isEqualTo(result);
    }

    @Test
    void updateMatrix4() {

        int[][] mat = {
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 1, 0, 1, 0, 1, 1}
        };
        int[][] result = {
                {2, 1, 0, 1, 2, 2, 2, 3, 3, 2},
                {2, 1, 0, 1, 1, 1, 1, 2, 2, 1},
                {3, 2, 1, 1, 0, 0, 0, 1, 1, 0},
                {2, 1, 1, 2, 1, 1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 2, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 1, 0, 1, 0, 1, 2}
        };

        assertThat(new Solution().

                updateMatrix(mat)).

                isEqualTo(result);
    }
}