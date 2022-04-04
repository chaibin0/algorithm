package leetcode.problems.q35;

import leetcode.problems.q35.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class SolutionTest {

    @Test
    @DisplayName("Input: nums = [1,3,5,6], target = 5")
    void searchInsert1() {


        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        assertThat(solution.searchInsert(nums, target)).isEqualTo(2);
    }

    @Test
    @DisplayName("Input: nums = [1,3,5,6], target = 2")
    void searchInsert2() {


        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        assertThat(solution.searchInsert(nums, target)).isEqualTo(1);
    }


    @Test
    @DisplayName("Input: nums = [1,3,5,6], target = 7")
    void searchInsert3() {


        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 7;

        assertThat(solution.searchInsert(nums, target)).isEqualTo(4);
    }


    @Test
    @DisplayName("Input: nums = [1,3,5,6], target = 0")
    void searchInsert4() {


        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 0;

        assertThat(solution.searchInsert(nums, target)).isEqualTo(0);
    }

    @Test
    @DisplayName("Input: nums = [1], target = 0")
    void searchInsert5() {


        Solution solution = new Solution();
        int[] nums = {1};
        int target = 0;

        assertThat(solution.searchInsert(nums, target)).isEqualTo(0);
    }

    @Test
    @DisplayName("Custom")
    void searchInsertCustom() {


        Solution solution = new Solution();
        int[] nums = {1, 3};
        int target = 1;

        assertThat(solution.searchInsert(nums, target)).isEqualTo(1);
    }

}