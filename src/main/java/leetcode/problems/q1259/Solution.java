package leetcode.problems.q1259;

class Solution {

    private int[] dp;
    private int modulo = 1000_000_007;

    public int numberOfWays(int numPeople) {
        this.dp = new int[numPeople + 1];
        this.dp[0] = 1;
        this.dp[2] = 1;
        return (int) solve(numPeople) % modulo;
    }

    public long solve(int numPeople) {

        if (dp[numPeople] != 0) {
            return dp[numPeople];
        }

        int temp = numPeople - 2;
        long answer = 0;

        for (int i = 0; i <= temp; i += 2) {
            long value = (solve(temp - i) % modulo) * (solve(i) % modulo);
            answer += (value % modulo);
            answer %= modulo;
        }

        this.dp[numPeople] = (int) answer;
        return answer;
    }
}
