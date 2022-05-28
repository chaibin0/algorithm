package leetcode.answers.q714;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxProfit() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int result = 8;
        assertThat(new Solution().maxProfit(prices, fee)).isEqualTo(result);
    }

    @Test
    void maxProfit2() {
        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        int result = 6;
        assertThat(new Solution().maxProfit(prices, fee)).isEqualTo(result);
    }
}