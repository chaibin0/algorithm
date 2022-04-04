package leetcode.problems.twosum;

import leetcode.problems.twosum.Solution2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2Test {

    @Test
    void twoSum1() {

        Solution2 solution = new Solution2();
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] answer = {1, 2};

        assertEquals(answer, solution.twoSum(nums, target));
    }

    @Test
    void twoSum2() {

        Solution2 solution = new Solution2();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] answer = {0, 1};

        assertEquals(answer, solution.twoSum(nums, target));
    }
}