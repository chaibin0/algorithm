package leetcode.q485

import kotlin.math.max

class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var answer = 0
        var count = 0
        for (i in nums) {
            if (i == 0) {
                answer = max(answer, count)
                count = 0
                continue
            }

            count++
        }

        answer = max(answer, count)

        return answer
    }
}