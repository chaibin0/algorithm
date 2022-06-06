package leetcode.problems.q413;

class Solution {

    public int numberOfArithmeticSlices(int[] nums) {

        if (nums.length < 3) {
            return 0;
        }
        int answer = 0;
        int count = 1;
        int difference = nums[1] - nums[0];

        for (int i = 2; i < nums.length; i++) {
            if (difference == nums[i] - nums[i - 1]) {
                count++;
                continue;
            }
            difference = nums[i] - nums[i - 1];
            answer += calculate(count);
            count = 1;
        }

        answer += calculate(count);
        return answer;
    }

    private int calculate(int count) {
        if (count < 2) {
            return 0;
        }

        int tmp = count - 1;
        return ((tmp + 1) * tmp) / 2;
    }
}