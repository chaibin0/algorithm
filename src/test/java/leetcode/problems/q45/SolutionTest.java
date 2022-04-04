package leetcode.problems.q45;

import leetcode.problems.q45.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void jump() {

        int[] nums = {2, 3, 1, 1, 4};
        int output = 2;
        assertThat(new Solution().jump(nums)).isEqualTo(output);
    }

    @Test
    void jump2() {

        int[] nums = {2, 3, 0, 1, 4};
        int output = 2;
        assertThat(new Solution().jump(nums)).isEqualTo(output);
    }
}