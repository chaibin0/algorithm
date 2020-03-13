package problems.twosum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void twoSum1() {

        Solution solution = new Solution();
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] answer = {1, 2};

        assertEquals(answer, solution.twoSum(nums, target));
    }

    @Test
    void twoSum2() {

        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] answer = {0, 1};

        assertEquals(answer, solution.twoSum(nums, target));
    }
}