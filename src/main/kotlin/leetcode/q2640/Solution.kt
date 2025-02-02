package leetcode.q2640

import kotlin.math.max

class Solution {
    fun findPrefixScore(nums: IntArray): LongArray {

        val results = LongArray(nums.size)
        var maximum = nums[0]

        results[0] = nums[0].toLong() + maximum

        for ((index, value) in nums.withIndex()) {
            if (index == 0) {
                continue
            }
            maximum = max(maximum, value)
            results[index] = results[index - 1] + maximum + value
        }

        return results
    }
}