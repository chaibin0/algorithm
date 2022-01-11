package problems.q81;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void search() {

        int[] nums = {1, 0, 1, 1, 1};
        int target = 0;

        assertThat(new Solution().search(nums, target)).isTrue();
    }

    @Test
    void search2() {

        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        int target = 2;

        assertThat(new Solution().search(nums, target)).isTrue();
    }
}