package leetcode.q487

import kotlin.math.max

class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {

        var last = 0
        var next = 0
        var zeroCount = 0
        var answer = 0
        for (num in nums) {
            if (num == 0 && zeroCount == 1) {
                answer = max(answer, last + next + 1)
                last = next
                next = 0
                continue
            }

            if (num == 0) {
                last = next
                next = 0
                zeroCount++
                continue
            }

            next++
        }

        if (zeroCount == 1) {
            answer = max(answer, last + next + 1)
        }

        if (zeroCount == 0) {
            answer = next
        }

        return answer
    }
}