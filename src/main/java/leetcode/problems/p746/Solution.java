package leetcode.problems.p746;

class Solution {

    private int[] dp1;
    private int[] dp2;

    public int minCostClimbingStairs(int[] cost) {
        dp1 = new int[cost.length];
        dp2 = new int[cost.length];

        if (cost.length == 1) {
            return cost[0];
        }

        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        dp1[0] = cost[0];
        dp2[0] = 0;

        for (int i = 1; i < cost.length; i++) {

            dp1[i] = Math.min(dp1[i - 1] + cost[i], dp2[i - 1] + cost[i]);
            dp2[i] = dp1[i - 1];
        }

        return Math.min(dp1[cost.length - 1], dp2[cost.length - 1]);
    }
}