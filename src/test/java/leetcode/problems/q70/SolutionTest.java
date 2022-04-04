package leetcode.problems.q70;

import leetcode.problems.q70.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void climbStairs() {
        int n = 2;
        assertThat(new Solution().climbStairs(n)).isEqualTo(2);
    }
}