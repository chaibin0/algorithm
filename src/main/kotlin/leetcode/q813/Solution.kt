package leetcode.q813

import kotlin.math.max

class Solution {

    lateinit var dp: Array<DoubleArray>
    lateinit var nums: IntArray
    var answer = 0
    fun largestSumOfAverages(nums: IntArray, k: Int): Double {
        this.dp = Array(nums.size) { DoubleArray(k + 1) { Double.MIN_VALUE } }
        this.nums = nums

        return dfs(0, k)
    }

    fun dfs(index: Int, k: Int): Double {

        if (index == nums.size) {
            return 0.0
        }

        if (dp[index][k] != Double.MIN_VALUE) {
            return dp[index][k]
        }

        if (k == 1) {
            val sum = (index until nums.size).sumOf { nums[it] }.toDouble()
            dp[index][k] = sum / (nums.size - index)
            return dp[index][k]
        }

        var sum = 0.0
        var maxValue = 0.0
        for (i in index until nums.size) {

            sum += nums[i]
            maxValue = max(maxValue, sum / (i - index + 1) + dfs(i + 1, k - 1))
        }

        dp[index][k] = maxValue
        return maxValue
    }
}
// 1, 2, 3, 4