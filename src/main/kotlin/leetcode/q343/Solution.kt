package leetcode.q343

import kotlin.math.max

class Solution {
    lateinit var dp: IntArray
    var n: Int = 0
    fun integerBreak(n: Int): Int {
        this.dp = IntArray(n + 1)
        this.n = n

        if (n <= 2) {
            return 1
        }

        if (n <= 3) {
            return 1
        }

        return dfs(n)
    }

    private fun dfs(remain: Int): Int {
        if (remain == 0) {
            return 0
        }

        if (dp[remain] != 0) {
            return dp[remain]
        }

        dp[remain] = if (remain > 1) remain else 1

        for (n in 1..remain) {
            dp[remain] = max(dp[remain], dfs(remain - n) * dfs(n))
        }

        return dp[remain]
    }
}