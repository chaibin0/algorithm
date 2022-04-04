package leetcode.problems.q57;

import leetcode.problems.q57.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void insert() {

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] answers = {{1, 5}, {6, 9}};

        assertThat(new Solution().insert(intervals, newInterval)).isEqualTo(answers);
    }
}