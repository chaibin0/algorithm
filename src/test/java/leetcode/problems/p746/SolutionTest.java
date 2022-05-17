package leetcode.problems.p746;

import leetcode.problems.p746.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void minCostClimbingStairs() {

        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int result = 6;

        assertThat(new Solution().minCostClimbingStairs(cost)).isEqualTo(result);
    }


    @Test
    void minCostClimbingStairs2() {

        int[] cost = {10, 15, 20};
        int result = 15;

        assertThat(new Solution().minCostClimbingStairs(cost)).isEqualTo(result);
    }
}