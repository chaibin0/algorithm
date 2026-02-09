package leetcode.q1043

import kotlin.math.max

class Solution {

    lateinit var dp: Array<IntArray>
    lateinit var nums: IntArray
    var k: Int = 0
    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        this.dp = Array(arr.size) { IntArray(k + 1) { Int.MIN_VALUE } }
        this.nums = arr
        this.k = k
        return dfs(0)
    }

    fun dfs(index: Int): Int {

        if (index == nums.size) {
            return 0
        }

        if (dp[index][k] != Int.MIN_VALUE) {
            return dp[index][k]
        }

        var maxValue = 0
        var total = 0

        var i = index
        while (i < nums.size && i < (index + k)) {
            maxValue = max(maxValue, nums[i])
            total = max(total, dfs(i + 1) + maxValue * (i - index + 1))
            i++
        }

        dp[index][k] = total
        return total
    }
}