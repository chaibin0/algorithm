package leetcode.problems.q56;

import leetcode.problems.q56.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void merge() {

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] expected = {
                {1, 6},
                {8, 10},
                {15, 18}
        };

        int[][] answers = new Solution().merge(intervals);
        assertThat(answers).isEqualTo(expected);
    }

    @Test
    void merge2() {

        int[][] intervals = {
                {1, 4},
                {4, 5}
        };

        int[][] expected = {
                {1, 5}
        };

        int[][] answers = new Solution().merge(intervals);
        assertThat(answers).isEqualTo(expected);
    }
}