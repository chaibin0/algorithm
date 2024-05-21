package leetcode.q1014

import kotlin.math.max

class Solution {
    fun maxScoreSightseeingPair(values: IntArray): Int {
        var answer = 0
        var currentValue = values.first()
        for (i in 1..values.lastIndex) {
            currentValue--
            answer = max(answer, currentValue + values[i])
            if (currentValue < values[i]) {
                currentValue = values[i]
            }
        }

        return answer
    }
}