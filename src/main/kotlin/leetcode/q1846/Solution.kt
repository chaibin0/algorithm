package leetcode.q1846

import kotlin.math.abs

class Solution {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        arr.sort()
        var answer = 1
        for (i in 1 until arr.size) {
            if (abs(arr[i] - answer) <= 1) {
                answer = arr[i]
                continue
            }

            answer++
        }

        return answer
    }
}
