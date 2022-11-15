package leetcode.q322

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {

        if (amount == 0) {
            return 0
        }

        coins.sortDescending()
        val dp = IntArray(amount + 1)
        val queue = ArrayDeque<Int>()

        for (coin in coins) {
            if (coin == amount) {
                return 1
            }

            if (coin > amount) {
                continue
            }

            dp[coin] = 1
            queue.add(coin)
        }

        while (queue.isNotEmpty()) {
            val currentValue = queue.removeFirst()
            for (coin in coins) {
                val nextCoin = currentValue + coin
                if (nextCoin < 0) {
                    continue
                }
                if (nextCoin == amount) {
                    return dp[currentValue] + 1
                }

                if (nextCoin > amount) {
                    continue
                }

                if (dp[nextCoin] != 0 && dp[nextCoin] <= (dp[currentValue] + 1)) {
                    continue
                }

                queue.add(nextCoin)
                dp[nextCoin] = dp[currentValue] + 1
            }
        }

        return if (dp[amount] != 0) dp[amount] else -1
    }
}