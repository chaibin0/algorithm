package leetcode.q128

import java.util.*
import kotlin.math.max

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var answer = 0
        val tm = TreeSet<Int>()
        for (num in nums) {
            tm.add(num)
        }


        var count = 0
        var nextValue = 0
        for (num in tm) {
            if (count == 0) {
                nextValue = num + 1
                count++
                continue
            }

            if (nextValue == num) {
                nextValue++
                count++
            } else {
                answer = max(answer, count)
                nextValue = num - 1
                count = 1
            }
        }
        return max(answer, count)
    }
}