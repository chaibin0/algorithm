package leetcode.q376

import kotlin.math.max

class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {

        var answer = 0
        var count = 1
        var positive = true
        var isFirst = true

        var lastValue = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] == lastValue) {
                answer = max(answer, count)
                continue
            }

            if (isFirst || check(positive, lastValue, nums[i])) {
                isFirst = false
                positive = (nums[i] - lastValue) > 0
                count++
            }
            lastValue = nums[i]
        }

        return max(answer, count)
    }

    private fun check(
        positive: Boolean, first: Int, second: Int
    ): Boolean {
        val between = second - first

        if (positive && between < 0) {
            return true
        }
        if (!positive && between > 0) {
            return true
        }

        return false
    }
}

fun main() {
    val nums: IntArray = intArrayOf(1, 17, 5, 10, 13, 15, 10, 5, 16, 8)

    println(Solution().wiggleMaxLength(nums))
}