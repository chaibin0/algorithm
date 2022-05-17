package leetcode.problems.q1567;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void getMaxLen1() {

        int[] nums = {1, -2, -3, 4};
        int result = 4;

        assertThat(new Solution().getMaxLen(nums)).isEqualTo(result);
    }

    @Test
    void getMaxLen2() {

        int[] nums = {0, 1, -2, -3, -4};
        int result = 3;

        assertThat(new Solution().getMaxLen(nums)).isEqualTo(result);
    }

    @Test
    void getMaxLen3() {

        int[] nums = {-1, -2, -3, 0, 1};
        int result = 2;

        assertThat(new Solution().getMaxLen(nums)).isEqualTo(result);
    }

    @Test
    void getMaxLen4() {

        int[] nums = {-1, 2};
        int result = 1;

        assertThat(new Solution().getMaxLen(nums)).isEqualTo(result);
    }

    @Test
    void getMaxLen5() {

        int[] nums = {-1000000000, -1000000000};
        int result = 2;

        assertThat(new Solution().getMaxLen(nums)).isEqualTo(result);
    }

    @Test
    void getMaxLen6() {

        int[] nums = {-16, 0, -14, 4, -13, -17, -19, -17, -21, -11, 12};
        int result = 8;

        assertThat(new Solution().getMaxLen(nums)).isEqualTo(result);
    }
}