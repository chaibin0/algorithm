package leetcode.q847

import kotlin.math.min
import kotlin.math.pow

class Solution {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val n = graph.size
        val bitSize = 2.0.pow(n).toInt()
        val dp = IntArray(bitSize) { Int.MAX_VALUE }
        dp[0] = 0

        for (i in 0 until bitSize) {
            for (j in 0..n) {
                val nextNodes = i or (1 shl j)
                dp[nextNodes] = min(nextNodes, dp[i] + 1)
            }
        }

        return dp[bitSize]
    }
}