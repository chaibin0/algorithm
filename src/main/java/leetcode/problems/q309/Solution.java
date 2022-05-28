package leetcode.problems.q309;

class Solution {
    private int[] keep;
    private int[] buy;
    private int[] sell;
    private int[] cooldown;


    public int maxProfit(int[] prices) {

        if (prices.length == 1) {
            return 0;
        }

        if (prices.length == 2) {
            return prices[0] < prices[1] ? prices[1] - prices[0] : 0;
        }

        int answer = 0;

        keep = new int[prices.length];
        buy = new int[prices.length];
        sell = new int[prices.length];
        cooldown = new int[prices.length];

        keep[0] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            keep[i] = prices[i - 1] < prices[i] ? keep[i - 1] : prices[i];
            buy[i] = cooldown[i - 1];
            sell[i] = (prices[i - 1] < prices[i] ? prices[i] - keep[i - 1] : 0) + buy[i - 1];
            cooldown[i] = sell[i - 1];
            answer = Math.max(answer, sell[i]);
        }

        return answer;
    }
}