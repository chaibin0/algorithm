package problems.q34;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void searchRange() {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        assertThat(new Solution().searchRange(nums, target)).isEqualTo(new int[]{3, 4});
    }

    @Test
    void searchRange2() {

        int[] nums = {2, 2};
        int target = 2;

        assertThat(new Solution().searchRange(nums, target)).isEqualTo(new int[]{0, 1});
    }
}