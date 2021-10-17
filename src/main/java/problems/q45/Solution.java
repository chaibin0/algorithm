package problems.q45;

import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        int lastIndex = nums.length - 1;

        if (lastIndex == 0) {
            return 0;
        }

        int[] dp = new int[lastIndex];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {

            //마지막까지 갈수 있는지 확인
            if (i + nums[i] >= lastIndex) {
                return dp[i] + 1;
            }

            // DP 1개씩
            int maximumJump = Math.min(lastIndex, i + nums[i]);
            for (int j = i + 1; j <= maximumJump; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        return dp[0];
    }
}
