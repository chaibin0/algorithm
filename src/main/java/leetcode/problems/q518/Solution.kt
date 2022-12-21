package leetcode.problems.q518

class Solution {

    lateinit var dp: Array<IntArray>

    fun change(amount: Int, coins: IntArray): Int {

        if(amount == 0){
            return 1
        }

        this.dp = Array(coins.size + 1) {
            IntArray(amount + 1)
        }

        coins.sort()
        for ((i, coin) in coins.withIndex()) {

            val index = i + 1
            for (currentAmount in 1..amount) {
                for (coinValue in coin..amount step coin) {
                    if (currentAmount > coinValue) {
                        dp[index][currentAmount] += dp[index - 1][currentAmount - coinValue]
                    }

                    if (currentAmount - coinValue == 0) {
                        dp[index][currentAmount]++
                    }
                }

                dp[index][currentAmount] += dp[index - 1][currentAmount]
            }
        }

        return dp[coins.size][amount]
    }
}