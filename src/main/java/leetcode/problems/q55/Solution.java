package leetcode.problems.q55;

class Solution {
    public boolean canJump(int[] nums) {

        int jumpCount = 1;

        for (int i = 0; i < nums.length && jumpCount > 0; i++) {

            jumpCount--;

            if (i + nums[i] >= nums.length - 1) {
                return true;
            }

            jumpCount = Math.max(jumpCount, nums[i]);
        }

        return false;
    }
}
