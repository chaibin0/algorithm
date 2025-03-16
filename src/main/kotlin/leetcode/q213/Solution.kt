package leetcode.q213

import kotlin.math.max

class Solution {

    private lateinit var dp: IntArray
    private var answer = 0

    fun rob(nums: IntArray): Int {
        if(nums.size == 1){
            return nums[0]
        }

        this.dp = IntArray(nums.size + 3) { 0 }
        dfs(0, nums, nums.size - 1)
        this.dp = IntArray(nums.size + 3) { 0 }
        dfs(1, nums, nums.size)
        return answer
    }

    fun dfs(position: Int, nums: IntArray, end: Int) {
        if (position == end) {
            return
        }

        this.dp[position + 3] = max(this.dp[position], this.dp[position + 1]) + nums[position]
        answer = max(answer, this.dp[position + 3])
        dfs(position + 1, nums, end)
    }
}