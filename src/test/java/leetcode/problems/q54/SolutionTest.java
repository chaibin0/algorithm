package leetcode.problems.q54;

import leetcode.problems.q54.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void spiralOrder() {

        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] output = {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};

        assertThat(new Solution().spiralOrder(matrix)).isEqualTo(output);
    }

    @Test
    void spiralOrder2() {

        int[][] matrix = {{1}};
        int[] output = {1};

        assertThat(new Solution().spiralOrder(matrix)).isEqualTo(output);
    }
}