package leetcode.problems.q122;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void maxProfit1() {

        int[] prices = {7, 1, 5, 3, 6, 4};
        assertThat(new Solution().maxProfit(prices)).isEqualTo(7);
    }

    @Test
    void maxProfit2() {

        int[] prices = {1, 2, 3, 4, 5};
        assertThat(new Solution().maxProfit(prices)).isEqualTo(4);
    }

    @Test
    void maxProfit3() {

        int[] prices = {7, 6, 4, 3, 1};
        assertThat(new Solution().maxProfit(prices)).isEqualTo(0);
    }
}