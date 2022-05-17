package leetcode.problems.q1567;

class Solution {

    int[] dp;

    public int getMaxLen(int[] nums) {
        int answer = 0;
        int count = 1;
        int index = 0;
        dp = new int[nums.length + 1];

        if (nums.length == 1) {
            return nums[0] > 0 ? 1 : 0;
        }

       for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                index = 0;
                count = 1;
                dp = new int[nums.length];
                continue;
            }

            if (nums[i] > 0) {
                dp[index] = count;
            } else {
                dp[++index] = count;
            }

            if (index % 2 != 0) {
                answer = Math.max(answer, dp[index] - (dp[0] + 1));
            } else {
                answer = Math.max(answer, dp[index]);
            }

            count++;
        }

        return answer;
    }
}