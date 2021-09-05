package problems.q34;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int minAnswer = Integer.MAX_VALUE;
    private int maxAnswer = 0;

    public int[] searchRange(int[] nums, int target) {

        solve(nums, 0, nums.length - 1, target);

        if (minAnswer == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{minAnswer, maxAnswer};
    }

    private void solve(int[] nums, int start, int end, int target) {

        if (end < start) {
            return;
        }

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            minAnswer = Math.min(minAnswer, mid);
            maxAnswer = Math.max(maxAnswer, mid);
            solve(nums, start, mid - 1, target);
            solve(nums, mid + 1, end, target);
            return;
        }

        if (nums[mid] < target) {
            solve(nums, mid + 1, end, target);
        } else {
            solve(nums, start, mid - 1, target);
        }
    }
}
