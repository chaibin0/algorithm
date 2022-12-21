package leetcode.q279

import kotlin.math.max
import kotlin.math.sqrt

class Solution {

    fun numSquares(n: Int): Int {

        val lastSquare = sqrt(n.toDouble()).toInt()
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = 0

        for (i in 1..dp.lastIndex) {
            for (square in 1..lastSquare) {
                val value = square * square
                if (value > i) {
                    break
                }
                dp[i] = max(dp[i], dp[i - value] + 1)
            }
        }

        return dp[n]
    }
}