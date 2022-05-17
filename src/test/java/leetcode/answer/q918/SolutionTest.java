package leetcode.answer.q918;

import leetcode.answer.q918.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxSubarraySumCircular1() {

        int[] nums = {1, -2, 3, -2};
        int output = 3;

        assertEquals(output, new Solution().maxSubarraySumCircular(nums));
    }


    @Test
    void maxSubarraySumCircular2() {

        int[] nums = {5, -3, 5};
        int output = 10;

        assertEquals(output, new Solution().maxSubarraySumCircular(nums));
    }


    @Test
    void maxSubarraySumCircular3() {

        int[] nums = {-3, -2, -3};
        int output = -2;

        assertEquals(output, new Solution().maxSubarraySumCircular(nums));
    }


}