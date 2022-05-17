package leetcode.problems.q1567;

class SolutionFail {

    boolean[] dp;

    public int getMaxLen(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            dp = new boolean[nums.length];
            dp[i] = nums[i] > 0 ? true : false;
            if (nums[i] == 0) {
                continue;
            }
            if (dp[i]) {
                answer = Math.max(answer, 1);
            }

            for (int j = i + 1; j < nums.length; j++) {
                boolean value = nums[j] > 0 ? true : false;
                dp[j] = !(dp[j - 1] ^ value);

                if (nums[j] == 0) {
                    break;
                }
                if (dp[j]) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }

        return answer;
    }
}