package leetcode.problems.q121;

class Solution {

    public int maxProfit(int[] prices) {

        int answer = 0;
        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (buy < prices[i]) {
                answer = Math.max(answer, prices[i] - buy);
            } else {
                buy = prices[i];
            }
        }
        return answer;
    }
}