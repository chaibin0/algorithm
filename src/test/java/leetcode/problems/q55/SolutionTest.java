package leetcode.problems.q55;

import leetcode.problems.q55.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void canJump() {

        int nums[] = {2, 3, 1, 1, 4};
        assertThat(new Solution().canJump(nums)).isTrue();
        int nums2[] = {3, 2, 1, 0, 4};
        assertThat(new Solution().canJump(nums2)).isFalse();
        int nums3[] = {0};
        assertThat(new Solution().canJump(nums3)).isTrue();
        int nums4[] = {1};
        assertThat(new Solution().canJump(nums4)).isTrue();
    }
}