package leetcode.answer.q1014;

import leetcode.answer.q1014.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void maxScoreSightseeingPair1() {

        int[] nums = {6, 9, 10, 5, 9, 10, 4, 5};
        int result = 18;
        assertThat(new Solution().maxScoreSightseeingPair(nums)).isEqualTo(result);
    }

    @Test
    void maxScoreSightseeingPair2() {

        int[] nums = {3, 7, 2, 3};
        int result = 9;
        assertThat(new Solution().maxScoreSightseeingPair(nums)).isEqualTo(result);
    }

    @Test
    void maxScoreSightseeingPair3() {

        int[] nums = {8, 1, 5, 2, 6};
        int result = 11;
        assertThat(new Solution().maxScoreSightseeingPair(nums)).isEqualTo(result);
    }

    @Test
    void maxScoreSightseeingPair4() {

        int[] nums = {1, 2};
        int result = 2;
        assertThat(new Solution().maxScoreSightseeingPair(nums)).isEqualTo(result);
    }
}