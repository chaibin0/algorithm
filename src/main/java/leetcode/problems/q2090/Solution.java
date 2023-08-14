package leetcode.problems.q2090;

class Solution {
    public int[] getAverages(int[] nums, int k) {

        int[] answers = new int[nums.length];
        int needLength = k * 2 + 1;

        int start = -k;
        int end = k;
        long totalElements = 0;

        for (int i = 0; i < end && i < nums.length; i++) {
            totalElements += nums[i];
        }

        for (int i = 0; i < nums.length; i++, start++, end++) {

            if (end >= nums.length) {
                answers[i] = -1;
                continue;
            }

            totalElements += nums[end];

            if (start < 0) {
                answers[i] = -1;
                continue;
            }

            if (start - 1 >= 0) {
                totalElements -= nums[start - 1];
            }

            answers[i] = (int) (totalElements / needLength);
        }

        return answers;
    }
}
