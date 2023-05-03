package programmers.level0.q181839

import kotlin.math.abs

class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0

        val isOddA = a % 2 == 1
        val isOddB = b % 2 == 1

        return when {
            isOddA && isOddB -> a * a + b * b
            isOddA || isOddB -> 2 * (a + b)
            else -> abs(a - b)
        }
    }
}