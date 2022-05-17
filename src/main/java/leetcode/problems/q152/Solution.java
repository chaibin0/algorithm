package leetcode.problems.q152;

class Solution {

    int[] minimumDp;
    int[] maximumDp;

    public int maxProduct(int[] nums) {
        int answer = nums[0];

        minimumDp = new int[nums.length];
        maximumDp = new int[nums.length];
        minimumDp[0] = nums[0];
        maximumDp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maximumDp[i] = Math.max(Math.max(minimumDp[i - 1] * nums[i], maximumDp[i - 1] * nums[i]), nums[i]);
            minimumDp[i] = Math.min(Math.min(minimumDp[i - 1] * nums[i], maximumDp[i - 1] * nums[i]), nums[i]);
            answer = Math.max(answer, maximumDp[i]);
        }

        return answer;
    }
}