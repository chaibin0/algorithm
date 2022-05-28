package leetcode.problems.q309;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxProfit() {
        int[] prices = {1, 2, 3, 0, 2};
        int result = 3;
        assertThat(new Solution().maxProfit(prices)).isEqualTo(result);
    }

    @Test
    void maxProfit2() {
        int[] prices = {6, 1, 3, 2, 4, 7};
        int result = 6;
        assertThat(new Solution().maxProfit(prices)).isEqualTo(result);
    }
}