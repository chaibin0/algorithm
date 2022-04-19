package leetcode.studyplan.p198;

class Solution {

    private int[] dp;

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            int first = (i - 2) >= 0 ? nums[i] + dp[i - 2] : nums[i];
            int second = (i - 3) >= 0 ? nums[i] + dp[i - 3] : nums[i];

            dp[i] = Math.max(first, second);
        }

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}