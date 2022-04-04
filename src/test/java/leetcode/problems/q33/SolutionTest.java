package leetcode.problems.q33;

import leetcode.problems.q33.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void search1() {

        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        assertThat(solution.search(nums, target)).isEqualTo(4);
    }

    @Test
    void search2() {

        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;

        assertThat(solution.search(nums, target)).isEqualTo(-1);
    }


    @Test
    void search3() {

        Solution solution = new Solution();
        int[] nums = {1, 3};
        int target = 2;

        assertThat(solution.search(nums, target)).isEqualTo(-1);
    }

    @Test
    void search4() {

        Solution solution = new Solution();
        int[] nums = {1, 3};
        int target = 3;

        assertThat(solution.search(nums, target)).isEqualTo(1);
    }

    @Test
    void search5() {

        Solution solution = new Solution();
        int[] nums = {3, 1};
        int target = 0;

        assertThat(solution.search(nums, target)).isEqualTo(-1);
    }


    @Test
    void search6() {

        Solution solution = new Solution();
        int[] nums = {2, 4, 5, 7, 1};
        int target = 0;

        assertThat(solution.search(nums, target)).isEqualTo(-1);
    }

}