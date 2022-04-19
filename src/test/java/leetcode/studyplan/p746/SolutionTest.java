package leetcode.studyplan.p746;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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