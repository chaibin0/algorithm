package leetcode.problems.q88;

import leetcode.problems.q88.Solution;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void merge() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {};

        new Solution().merge(nums1, 5, nums2, 0);
    }

    @Test
    void merge2() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        new Solution().merge(nums1, 3, nums2, 3);
    }
}