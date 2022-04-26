package leetcode.problems.q213;

class Solution {

    private int[] dp;

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int start, int end) {

        dp = new int[end];
        if(end - start == 1){
            return nums[start];
        }
        for (int i = start; i < end; i++) {

            int first = (i - 2) >= start ? nums[i] + dp[i - 2] : nums[i];
            int second = (i - 3) >= start ? nums[i] + dp[i - 3] : nums[i];

            dp[i] = Math.max(first, second);
        }

        return Math.max(dp[end - 1], dp[end - 2]);
    }
}